package com.zzf.music.identity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzf.music.identity.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 * @description 针对表【t_user_info】的数据库操作Mapper
 * @createDate 2024-05-31 00:29:20
 * @Entity com.zzf.music.identity.entity.UserInfo
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 查询用户信息通过登录名
     *
     * @param loginName 登录名
     * @return 用户信息
     */
    UserInfo selectByLoginName(String loginName);

}




