//package com.zzf.music.gateway.config;
//
//
//import com.zzf.music.gateway.entity.WXUser;
//import com.zzf.music.gateway.filter.JwtTokenFilter;
//import com.zzf.music.gateway.utils.JwtTokenProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private final JwtTokenProvider jwtTokenProvider;
//    private final RedisConnectionFactory redisConnectionFactory;
//    private final UserDetailsService userDetailsService;
//    @Autowired
//    public SecurityConfig(JwtTokenProvider jwtTokenProvider, RedisConnectionFactory redisConnectionFactory, UserDetailsService userDetailsService) {
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.redisConnectionFactory = redisConnectionFactory;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        // todo 提供你的自定义UserDetailsService实现
////        return new YourUserDetailsService();
//        return new WXUser();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/auth/**").permitAll() // 放开认证接口
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(new JwtTokenFilter(jwtTokenProvider,redisConnectionFactory,userDetailsService), UsernamePasswordAuthenticationFilter.class); // 添加JWT过滤器
//    }
//}
//
//
