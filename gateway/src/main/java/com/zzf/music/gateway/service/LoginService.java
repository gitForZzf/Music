package com.zzf.music.gateway.service;

import com.zzf.music.gateway.entity.UserInfo;
import reactor.core.publisher.Mono;

public interface LoginService
{
   /**
    * 登录
    * @param userInfo 用户信息
    * @return 返回token
    */
   Mono<String> login(UserInfo userInfo);
}
