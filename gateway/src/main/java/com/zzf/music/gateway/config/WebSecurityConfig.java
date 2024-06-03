package com.zzf.music.gateway.config;

import com.zzf.music.gateway.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors(cors -> cors
                .configurationSource(corsConfigurationSource())
        ).csrf().disable()
                .authorizeRequests()
                .antMatchers("/music/auth/login").permitAll()  // 允许访问登录路径
                .anyRequest().authenticated() // 其他路径需要认证
                .and()
                .formLogin()
//                .loginPage("/music/auth/login")
                .and()
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        // 创建一个CorsConfiguration对象来定义CORS细节
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "http://127.0.0.1:8080", "http://192.144.239.113:8080")); // 允许跨域请求的源，生产环境应具体指定
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // 允许的HTTP方法
        configuration.setAllowedHeaders(Collections.singletonList("*")); // 允许的头信息
        configuration.setExposedHeaders(Collections.singletonList("*")); // 暴露的头信息
        configuration.setMaxAge(3600L); // 预检请求的缓存时间
        configuration.setAllowCredentials(true); // 是否允许携带凭证（cookies）

        // 创建一个CorsConfigurationSource对象，并注册CORS配置
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        // 返回CORS配置的源
        return source;
    }
}