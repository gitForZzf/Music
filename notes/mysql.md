## 安装mysql5.7
要在终端或命令行下安装MySQL 5.7，可以按照以下步骤进行：

### 首先，确保你的系统已经安装了MySQL的依赖库。可以使用以下命令安装：
    sudo apt-get update
    sudo apt-get install libaio1
## 下载MySQL 5.7的yum仓库配置文件：
    sudo wget https://dev.mysql.com/get/mysql57-community-release-el7-11.noarch.rpm
## 安装MySQL 5.7的yum仓库配置文件：
    sudo rpm -Uvh mysql57-community-release-el7-11.noarch.rpm
## 清除yum缓存：
    sudo yum clean all
## 安装MySQL 5.7社区版服务器：
    sudo yum install mysql-community-server
## 报错解决
    1、All matches were filtered out by modular filtering for argument: mysql-community-server Error: Unable to find a match: mysql-community-server
    模块过滤导致无法找到mysql-community-server软件包的问题。这可能是因为在你的系统中启用了模块化仓库    
    解决办法：
        禁用模块化仓库：
            sudo dnf module disable mysql
        清除yum缓存：
            sudo yum clean all
        再次尝试安装mysql-community-server：
            sudo yum install mysql-community-server
    2、继续报错： You can remove cached packages by executing 'yum clean packages'. Error: GPG check FAILED
    遇到了GPG校验失败的问题。这通常是由于下载的软件包的GPG签名与系统中的GPG密钥不匹配导致的
    解决办法：
    禁用GPG校验安装软件包：
        sudo yum install mysql-community-server --nogpgcheck
    3、继续报错： Error: Transaction test error: file /etc/my.cnf from install of mysql-community-server-5.7.44-1.el7.x86_64 conflicts with file from package mariadb-connector-c-config-3.1.11-2.oc8.1.noarch
    遇到了文件冲突的问题，其中/etc/my.cnf文件在mysql-community-server和mariadb-connector-c-config软件包中都存在，导致安装失败。
    解决办法：
    卸载mariadb-connector-c-config软件包
    sudo yum remove mariadb-connector-c-config
## 重新 执行 sudo yum install mysql-community-server --nogpgcheck  安装成功

## 启动mysql服务
    启动MySQL服务并设置开机自启：
    sudo systemctl start mysqld
    sudo systemctl enable mysqld

## 获取mysql初始密码
    获取初始密码。MySQL 5.7安装完成后，会生成一个临时密码。运行以下命令获取临时密码：
    sudo grep 'temporary password' /var/log/mysqld.log
## 使用临时密码登录MySQL，并设置新密码（注意密码要被单引号包裹）：
    mysql -u root -p
    ALTER USER root@localhost IDENTIFIED BY 'your_new_password';

## 密码
    要求必须包含大小写字母 特殊符合和数字  可在配置文件中关闭校验（本次没关）

## 可以通过以下命令检查MySQL服务状态：
    sudo systemctl status mysqld

## 防火墙放行 3306 端口

## 开启mysql远程访问
    要允许远程访问MySQL数据库，你需要按照以下步骤进行设置：
    
    登录到你的MySQL服务器上：
    mysql -u root -p
    在MySQL命令行中，执行以下命令来允许远程访问：
    GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '你的密码' WITH GRANT OPTION;
    请将你的密码替换为你的MySQL root用户的密码。
    
    刷新权限使更改生效：
    FLUSH PRIVILEGES;
    重启mysql
    sudo systemctl restart mysqld

## 新建数据库 music
    在MySQL 5.7创建数据库时，常见的字符集和排序规则选择是UTF-8字符集（utf8mb4）和UTF-8通用排序规则（utf8mb4_general_ci）。这个选择适用于大多数应用程序，并能够支持多种语言和字符类型。
