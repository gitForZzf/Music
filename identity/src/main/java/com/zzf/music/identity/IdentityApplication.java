package com.zzf.music.identity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@MapperScan(basePackages = {"com.zzf.music.identity.dao"})
public class IdentityApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(IdentityApplication.class, args);
        System.out.println("启动成功");
    }

}
