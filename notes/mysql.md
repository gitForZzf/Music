## 安装mysql5.7
要在终端或命令行下安装MySQL 5.7，可以按照以下步骤进行：

### 首先，确保你的系统已经安装了MySQL的依赖库。可以使用以下命令安装：
    sudo apt-get update
    sudo apt-get install libaio1
### 接下来，下载MySQL 5.7的安装包。可以从MySQL官方网站下载对应版本的安装包，或者使用以下命令下载：
    wget https://dev.mysql.com/get/Downloads/MySQL-5.7/mysql-5.7.35-linux-glibc2.12-x86_64.tar.gz
### 解压下载的安装包：
    tar -zxvf mysql-5.7.35-linux-glibc2.12-x86_64.tar.gz
### 将解压后的文件夹移动到指定目录：
    sudo mv mysql-5.7.35-linux-glibc2.12-x86_64 /usr/local/mysql
### 进入MySQL安装目录，初始化MySQL数据库：
    cd /usr/local/mysql
    sudo ./bin/mysqld --initialize --user=mysql
### 启动MySQL服务：
    sudo ./bin/mysqld_safe --user=mysql &
### 最后，设置MySQL root用户密码：
    sudo ./bin/mysql_secure_installation
完成以上步骤后，你就成功在终端或命令行下安装了MySQL 5.7

## 密码
    要求必须包含大小写字母 特殊符合和数字  可在配置文件中关闭校验（本次没关）
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
