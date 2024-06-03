package com.zzf.music.gateway.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
//    @Bean
//    public RewriteFunction<String, String> rewriteFunction() {
//        return (exchange, s) -> {
//            String requestPath = exchange.getRequest().getPath().value();
//            return Mono.just(requestPath.replace("/music/user/", "/user/"));
//        };
//    }
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("music_user_route", r -> r.path("/music/user/**")
//                        .filters(f -> f.rewritePath("/music/user/(?<segment>.*)", "/user/${segment}"))
//                        .uri("http://127.0.0.1:8910"))
//                .build();
//    }
}

