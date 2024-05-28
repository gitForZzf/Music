## 安装redis

    输入以下命令以安装Redis：
    sudo yum install redis
    安装完成后，可以输入以下命令启动Redis服务：
    sudo systemctl start redis
    可以使用以下命令检查Redis服务是否正在运行：
    sudo systemctl status redis

## 防火墙放行6379 端口

## redis 设置远程连接

    编辑Redis配置文件：通常名为redis.conf（本次服务器路径为/etc/redis.conf）
    
    找到bind指令，并将其修改为你服务器的IP地址，或者使用0.0.0.0来监听所有接口。
    
    确保protected-mode设置为no，以允许远程连接。
    
    确保port指令设置为你想要Redis监听的端口，默认为6379。
    
    如果你的Redis版本是6.0或更高，还需要确保cluster-enabled设置为no或者你正在运行一个Redis集群。
    
    保存并关闭配置文件。
    示例配置更改：
        # 修改前
        bind 127.0.0.1
        
        # 修改后
        bind 0.0.0.0
        
        # 修改前（如果存在）
        protected-mode yes
        
        # 修改后
        protected-mode no
    重启Redis服务：
    sudo systemctl restart redis.service

## 设置用户名密码 
    redis.conf文件中
    进入 Vim 编辑器。
    按下 / 键（斜杠）来进入搜索模式。
    输入你想要搜索的内容(requirepass foobared)，然后按下 Enter 键。
    将foobared 修改成你想要的密码。
    重启Redis服务：
    sudo systemctl restart redis.service