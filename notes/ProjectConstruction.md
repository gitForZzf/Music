# Music
music Demo
## 在github创建项目
    参考 https://blog.csdn.net/weixin_50592077/article/details/129852095

## 中文乱码
    控制台和浏览器中文乱码 在ieda设置中 File encodings 设置为UTF-8 后解决

## 子模块打包启动时爆错 报错没有主清单属性
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
    -- 修改后 为解决
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <mainClass>your.package.YourMainClass</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
    -- 最后如下修改 成功
     <build>
            <plugins>
    
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.8.1</version><!-- 配置中的版本号 -->
                    <configuration>
                        <source>1.8</source><!-- 设置源代码的JDK版本 -->
                        <target>1.8</target><!-- 设置目标代码的JDK版本 -->
                        <encoding>UTF-8</encoding><!-- 设置编码方式 -->
                    </configuration>
                </plugin>
                <!--maven 打包插件-->
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                    <version>${spring-boot.version}</version>
                    <configuration>
                        <mainClass>com.zzf.music.identity.IdentityApplication</mainClass><!-- 配置启动类 -->
                        <skip>false</skip><!--是否忽略启动类-->
                    </configuration>
                    <executions>
                        <execution>
                            <id>repackage</id>
                            <goals>
                                <goal>repackage</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>
    
            </plugins>
        </build>