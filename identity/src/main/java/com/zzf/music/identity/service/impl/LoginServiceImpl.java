package com.zzf.music.identity.service.impl;

import com.zzf.music.identity.entity.LoginUser;
import com.zzf.music.identity.entity.UserInfo;
import com.zzf.music.identity.service.LoginService;
import com.zzf.music.identity.utils.JwtUtil;
import com.zzf.music.platform.entity.ResponseResult;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseResult<Map<String, Object>> login(UserInfo userInfo) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userInfo.getLoginName(),
                            userInfo.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            LoginUser loginUser = (LoginUser)authentication.getPrincipal();
            final String token = JwtUtil.createJWT(loginUser.getUser().getPkUserInfo());
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            return new ResponseResult<>(200, "认证成功", map);
        } catch (BadCredentialsException e) {
            // 用户名或密码错误
            return new ResponseResult<>(401, "认证失败：用户名或密码错误", null);
        } catch (Exception e) {
            // 其他认证异常，例如用户账户锁定等
            return new ResponseResult<>(401, "认证失败：" + e.getMessage(), null);
        }
    }
}
