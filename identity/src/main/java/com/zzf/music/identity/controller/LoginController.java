package com.zzf.music.identity.controller;

import com.zzf.music.identity.entity.UserInfo;
import com.zzf.music.identity.service.LoginService;
import com.zzf.music.platform.entity.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class LoginController {

    @Resource
    LoginService loginService;

    @PostMapping("/music/auth/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody UserInfo userInfo) {
        return loginService.login(userInfo);
    }

    @PostMapping("/music/auth/logout")
    public <T> ResponseResult<T> logout() {
        return new ResponseResult<>(200, "退出成功");
    }
}
