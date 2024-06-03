## 启动报错 
    The bean 'requestDataValueProcessor', defined in class path resource [org/springframework/security/config/annotation/web/reactive/WebFluxSecurityConfiguration.class], could not be registered. A bean with that name has already been defined in class path resource [org/springframework/security/config/annotation/web/configuration/WebMvcSecurityConfiguration.class] and overriding is disabled.
    解决方式：用程序上下文中启用 bean 覆盖功能，方法是设置 spring.main.allow-bean-definition-overriding=true
## 重写 UserDetailsService 和 LoginUser implements UserDetails
    这样检权的时候，就会调用 UserDetailsService 的 loadUserByUsername 方法 是从数据库中查询的了

## 密码存储
    密码存储在数据库中，使用 明文 需要在密码前加{noop}
## A component required a bean of type 'org.springframework.security.config.annotation.ObjectPostProcessor' that could not be found.
    解决方式：在启动类中添加  注解
    @EnableGlobalMethodSecurity(prePostEnabled = true)

## 权限认证失败
    不走实现的userDetailService
## 若是启动报错
    org.springframework.security.config.annotation.AlreadyBuiltException: This object has already been built
    就将配置类的.build()方法注释掉，因为他是链式编程，第一次调用build方法，就会构建对象，第二次调用build方法，就会报错


















