package com.zzf.music.gateway.controller;

import com.zzf.music.gateway.entity.UserInfo;
import com.zzf.music.gateway.service.LoginService;
import com.zzf.music.platform.entity.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    LoginService loginService;

    @PostMapping("/music/auth/login")
    public <T> ResponseResult<T> login(@RequestBody UserInfo userInfo) {
        login(userInfo).subscribe(
                result -> {
                    // 登录成功，result是JWT令牌字符串
                    System.out.println("Login successful: " + result);
                },
                error -> {
                    // 登录失败，error是异常或错误消息
                    System.out.println("Login failed: " + error.getMessage());
                }
        );
        return new ResponseResult<>(200, "登录成功");
    }
    @PostMapping("/music/auth/logout")
    public <T> ResponseResult<T> logout() {
        return new ResponseResult<>(200, "退出成功");
    }
}
