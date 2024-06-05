package com.zzf.music.identity.service;

import com.zzf.music.identity.entity.UserInfo;
import com.zzf.music.platform.entity.ResponseResult;

import java.util.Map;

public interface LoginService {
    /**
     * 登录
     *
     * @param userInfo 用户信息
     * @return 返回token
     */
     ResponseResult<Map<String, Object>> login(UserInfo userInfo);
}
