package com.zzf.music.gateway.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class JwtUser implements UserDetails {
    /**
     * 主键
     */
    private String pk_user_info;
    /**
     * 用户名
     */
    private String user_name;
    /**
     * 用户登录名
     */
    private String login_name;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户头像
     */
    private String photo;
    /**
     * 用户来源
     */
    private String source;

    /**
     * 用户状态
     */
    private Integer state;
    /**
     * 用户权限
     */
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(){
    }

    public JwtUser(String username, String password, Integer state,  Collection<? extends GrantedAuthority> authorities){
        this.login_name = username;
        this.password = password;
        this.state = state;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.login_name;
    }

    public String getPassword() {
        return this.password;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
