package com.zzf.music.gateway.controller;

import com.zzf.music.gateway.entity.UserInfo;
import com.zzf.music.gateway.service.LoginService;
import com.zzf.music.platform.entity.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    LoginService loginService;

    @PostMapping("/music/auth/login")
    public <T> ResponseResult<T> login(@RequestBody UserInfo userInfo) {
        String login = loginService.login(userInfo);
        System.out.println(login);
        return new ResponseResult<>(200, "登录成功");
    }

    @PostMapping("/music/auth/logout")
    public <T> ResponseResult<T> logout() {
        return new ResponseResult<>(200, "退出成功");
    }
}
