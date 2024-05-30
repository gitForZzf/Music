package com.zzf.music.gateway.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserInfo {
    /**
     * 主键
     */
    private String pkUserInfo;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户登录名
     */
    private String loginName;
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
     * 创建日期
     */
    private LocalDate createDate;
    /**
     * 创建日期时间
     */
    private LocalDateTime createDateTime;
    /**
     * 修改日期
     */
    private LocalDate modDate;
    /**
     * 修改日期时间
     */
    private LocalDateTime modDateTime;
    /**
     * 时间戳
     */
    private String timeStamp;

}
