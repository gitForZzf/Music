## vue 前端服务器部署

### 1、打包项目

    npm run build
    打包后的文件在项目的根目录下的dist文件夹中

### 2、使用nginx代理 （本次采取直接修改原来的配置文件没有新建配置文件）

    如果您将Vue项目的dist文件放到服务器的/usr/zzf目录下，并且您正在使用Nginx作为HTTP服务器，您可以按照以下步骤配置Nginx来实现外网通过服务器IP访问您的服务：
    
    创建一个Nginx配置文件：在Nginx的配置目录中创建一个新的配置文件，比如/etc/nginx/sites-available/vue_project。
    
    编辑配置文件：使用文本编辑器打开该配置文件，并添加以下内容：
    
    server {
    listen 80;  # 监听服务器的80端口，即HTTP默认端口
    
        server_name YOUR_SERVER_IP;  # 替换为您服务器的公网IP地址或域名
    
        root /usr/zzf/dist;  # 指定Vue项目的打包文件所在的路径
    
        index index.html;  # 指定默认的索引文件
    
        location / {
            try_files $uri $uri/ /index.html;  # 尝试匹配URL，如果文件或目录不存在，则返回index.html
        }
    }
    确保替换YOUR_SERVER_IP为您服务器的公网IP地址或域名，并将root指令的路径设置为您的Vue项目dist目录的绝对路径。
    
    启用站点：在Nginx的sites-enabled目录中创建一个符号链接，指向刚刚创建的配置文件。可以使用以下命令完成：
    sudo ln -s /etc/nginx/sites-available/vue_project /etc/nginx/sites-enabled/
    检查配置：确保您的Nginx配置文件语法正确：
    sudo nginx -t
    如果没有错误提示，则说明配置文件语法正确。
    
    重新加载Nginx：重新加载Nginx以使配置生效：
    sudo systemctl reload nginx

## 配置完成 访问500 或404

    查询nginx的error日志为好不到index.html文件 
    将前端目录的绝对路径都 chmod -R 755 后 有权限后可以正常访问