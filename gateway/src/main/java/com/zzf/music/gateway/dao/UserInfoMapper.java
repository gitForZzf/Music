package com.zzf.music.gateway.dao;

import com.zzf.music.gateway.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【t_user_info】的数据库操作Mapper
* @createDate 2024-05-31 00:29:20
* @Entity com.zzf.music.gateway.entity.UserInfo
*/
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 查询用户信息通过登录名
     * @param loginName 登录名
     * @return 用户信息
     */
    UserInfo selectByUserName(String loginName);

}



