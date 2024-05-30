package com.zzf.music.gateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzf.music.gateway.entity.UserInfo;
import com.zzf.music.gateway.service.UserInfoService;
import com.zzf.music.gateway.dao.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_user_info】的数据库操作Service实现
* @createDate 2024-05-31 00:29:20
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService{

}




