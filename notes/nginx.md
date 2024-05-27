## 安装nginx

    输入以下命令以安装Nginx：
    sudo yum install nginx
    安装完成后，可以输入以下命令启动Nginx服务：
    sudo systemctl start nginx
    可以使用以下命令检查Nginx服务是否正在运行：
    sudo systemctl status nginx

## 将80端口代理到8950端口 （一般修改nginx配置文件会将之前的备份留痕）

     Nginx 的配置文件中（通常位于 /etc/nginx/nginx.conf 或 /etc/nginx/conf.d/ 目录下的一个文件、
    本次改的为 /etc/nginx/nginx.conf 
    下面的配置可以执行代理 优先级 从前到后 逐次减弱
    server {
    listen 80;
    
        location /a {
            proxy_pass http://localhost:8950;
        }
    
        location /b {
            proxy_pass http://localhost:8950;
        }
    
        location / {
            proxy_pass http://localhost:8080;
        }
    }
    配置完使用 sudo systemctl reload nginx 命令重新加载配置文件

## 检查配置：确保您的Nginx配置文件语法正确：

    sudo nginx -t