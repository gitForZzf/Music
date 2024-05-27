# 环境搭建

## 服务器购买

    买的腾讯轻量服务器 应用为OpenCloudOS（类CentOS）

## 服务器 安装jar8环境

    首先，确保你的系统已经安装了包管理工具（如yum等）。
    打开终端或命令行窗口，输入以下命令以更新软件包列表：
    sudo yum check-update
    然后，输入以下命令以安装Java 8：
    sudo yum install java-1.8.0-openjdk
    安装完成后，可以输入以下命令验证Java版本：
    java -version

## 上传服务

    -- 创建项目目录 /home/lighthouse 下新建mypro/music目录用于存放本次项目
    mkdir mypro
    mkdir mypro/music
    使用腾讯服务器自带的SFTP将 程序上传到 /home/lighthouse/mypro/music/目录下

## 启动程序

    直接启动报错 Caused by: java.net.SocketException: Permission denied
    得用高权限用户启动并且确定防火墙放行指定使用的端口
    sudo su
    在/home/lighthouse/mypro/music/目录下 java -jar XXXX.jar

## 测试

    扫描微信登录二维码成功在手机端看到用户信息
