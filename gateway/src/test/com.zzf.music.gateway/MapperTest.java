package com.zzf.music.gateway;

import com.zzf.music.gateway.dao.UserInfoMapper;
import com.zzf.music.gateway.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = GatewayApplication.class)

public class MapperTest {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Test
    public void test() {
        UserInfo zzf = userInfoMapper.selectByLoginName("zzf");
        System.out.println(zzf);
    }
}