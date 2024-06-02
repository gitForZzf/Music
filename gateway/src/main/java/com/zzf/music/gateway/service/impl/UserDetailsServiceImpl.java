package com.zzf.music.gateway.service.impl;

import com.zzf.music.gateway.dao.UserInfoMapper;
import com.zzf.music.gateway.entity.LoginUser;
import com.zzf.music.gateway.entity.UserInfo;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements ReactiveUserDetailsService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public Mono<UserDetails> findByUsername(String s) {

        UserInfo user = userInfoMapper.selectByLoginName(s);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("'%s'.这个用户不存在", s));

        }
        return Mono.just(new LoginUser(user));
    }
}