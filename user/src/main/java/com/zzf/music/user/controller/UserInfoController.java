package com.zzf.music.user.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @GetMapping("/userInfo")
    public String getUserInfo() {
        return "user info";
    }
}
