package com.zzf.music.identity.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 微信用户信息
 * @author
 * @date 2023/11/1 16:20
 */
@Data
public class WXUser implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;

    private Long id;
    /**
     * 系统用户id
     */
    private Long userId;
    /**
     * 用户的唯一标识
     */
    private String openid;
    /**
     * access_token
     */
    private String accessToken;

    /**
     * refresh_token
     */
    private String refreshToken;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 性别(0未知,1男性,2女性)
     */
    private String sex;
    /**
     * 用户个人资料填写的省份
     */
    private String province;
    /**
     * 普通用户个人资料填写的城市
     */
    private String city;
    /**
     * 国家，如中国为CN
     */
    private String country;
    /**
     * 用户头像
     */
    private String headimgurl;
    /**
     * 用户特权信息，json 数组
     */
    private String privilege;
    /**
     *
     */
    private String unionid;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;
}