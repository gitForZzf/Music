package com.zzf.music.gateway.service.impl;

import com.zzf.music.gateway.dao.UserInfoMapper;
import com.zzf.music.gateway.entity.LoginUser;
import com.zzf.music.gateway.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo user = userInfoMapper.selectByLoginName(s);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("'%s'.这个用户不存在", s));

        }
        return new LoginUser(user);
    }

}