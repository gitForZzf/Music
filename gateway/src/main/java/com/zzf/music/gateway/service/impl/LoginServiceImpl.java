package com.zzf.music.gateway.service.impl;

import com.zzf.music.gateway.entity.UserInfo;
import com.zzf.music.gateway.service.LoginService;
import com.zzf.music.gateway.utils.JwtUtil;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private ReactiveAuthenticationManager authenticationManager;


    @Override
    public Mono<String> login(UserInfo userInfo) {
        Mono<UserInfo> loginUserMono = Mono.just(userInfo);
        return loginUserMono
                .flatMap(loginUser -> {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    loginUser.getLoginName(), loginUser.getPassword());

                    return authenticationManager.authenticate(authenticationToken)
                            .flatMap(authentication -> {
                                // 认证成功后，使用JwtUtil生成令牌
                                String jwtToken = JwtUtil.createJWT(authentication.getName());
                                // 返回包含JWT令牌的Mono
                                return Mono.just("JWT " + jwtToken);
                            })
                            .onErrorMap(AuthenticationException.class, ex -> {
                                // 认证失败时，将异常转换为特定的错误消息
                                return new RuntimeException("Authentication failed");
                            })
                            .onErrorReturn("Authentication failed"); // 认证失败时返回的错误消息
                });
    }
}
