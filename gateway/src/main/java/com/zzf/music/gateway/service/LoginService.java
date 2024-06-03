package com.zzf.music.gateway.service;

import com.zzf.music.gateway.entity.UserInfo;

public interface LoginService {
    /**
     * 登录
     *
     * @param userInfo 用户信息
     * @return 返回token
     */
    String login(UserInfo userInfo);
}
