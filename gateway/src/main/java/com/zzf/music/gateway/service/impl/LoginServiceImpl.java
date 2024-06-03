package com.zzf.music.gateway.service.impl;

import com.zzf.music.gateway.entity.UserInfo;
import com.zzf.music.gateway.service.LoginService;
import com.zzf.music.gateway.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public String login(UserInfo userInfo) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userInfo.getLoginName(), userInfo.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return JwtUtil.createJWT(userInfo.getPkUserInfo());
    }
}
