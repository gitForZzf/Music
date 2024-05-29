## 网关
    网关和mvc是互斥的
    解决方式：
    1、设置 Spring Boot 的 web 应用类型为 reactive：
    在你的 Spring Boot 应用程序的配置文件（如 application.properties 或 application.yml）中添加以下配置：
    
    spring.main.web-application-type=reactive
    2、移除 Spring MVC 依赖：

## 网关不支持路径中有变量 就采取了过滤器的方式