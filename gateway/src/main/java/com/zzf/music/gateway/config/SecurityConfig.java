//package com.zzf.music.gateway.config;
//
//import com.zzf.music.gateway.service.impl.UserDetailsServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.ReactiveAuthenticationManager;
//import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
////    private static final String[] excludeAuthPages = {"/music/auth/login"};
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public ReactiveAuthenticationManager reactiveAuthenticationManager(UserDetailsServiceImpl userDetailsService, PasswordEncoder passwordEncoder) {
//        UserDetailsRepositoryReactiveAuthenticationManager authenticationManager = new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
//        authenticationManager.setPasswordEncoder(passwordEncoder);
//        return authenticationManager;
//    }
//
//
//    // 定义一个CORS配置的源
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        // 创建一个CorsConfiguration对象来定义CORS细节
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "http://127.0.0.1:8080", "http://192.144.239.113:8080")); // 允许跨域请求的源，生产环境应具体指定
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // 允许的HTTP方法
//        configuration.setAllowedHeaders(Collections.singletonList("*")); // 允许的头信息
//        configuration.setExposedHeaders(Collections.singletonList("*")); // 暴露的头信息
//        configuration.setMaxAge(3600L); // 预检请求的缓存时间
//        configuration.setAllowCredentials(true); // 是否允许携带凭证（cookies）
//
//        // 创建一个CorsConfigurationSource对象，并注册CORS配置
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//
//        // 返回CORS配置的源
//        return source;
//    }
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        return http  // 开启CORS支持
//                .cors(cors -> cors
//                        .configurationSource(corsConfigurationSource())
//                ).csrf(ServerHttpSecurity.CsrfSpec::disable)
//                .authorizeExchange()// 允许访问配置的路径
//                .pathMatchers("/music/auth/login").permitAll()  // 允许访问登录路径
//                .anyExchange().authenticated()
//                .and()
//                .formLogin()
////                .loginPage("/music/auth/login")
//                .and()
//                .build();
//    }
//
//}
