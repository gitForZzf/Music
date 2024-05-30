package com.zzf.music.gateway.service.impl;

import com.zzf.music.gateway.dao.UserInfoMapper;
import com.zzf.music.gateway.entity.JwtUser;
import com.zzf.music.gateway.entity.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo user = userInfoMapper.selectByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("'%s'.这个用户不存在", s));

        }
//        List<SimpleGrantedAuthority> collect = jwtUser.getRoles().stream().map(Role::getRolename).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new JwtUser(user.getLoginName(), user.getPassword(), 1, null);

    }
}