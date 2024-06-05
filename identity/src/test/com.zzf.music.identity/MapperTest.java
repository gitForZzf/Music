package com.zzf.music.identity;

import com.zzf.music.identity.dao.UserInfoMapper;
import com.zzf.music.identity.entity.UserInfo;
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