package com.zzf.music.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@MapperScan(basePackages = {"com.zzf.music.gateway.dao"})
public class GatewayApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(GatewayApplication.class, args);
        System.out.println("启动成功");
    }

}
