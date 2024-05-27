## 内网穿透

    https://natapp.cn/member/dashborad
    1、登录注册
    2、购买隧道 免费隧道（只为了本地测试）
    3、选择隧道协议 Web: 普通型http(s)隧道穿透,用于搭建网站,微信开发等穿透到本地web服务.
    4、客户端下载（本次为Windows10环境）
    5、解压后为exe文件
    6、在exe同层目录创建config.ini文件
    7、在config.ini文件中写入如下内容（在natapp 教程文档中有）
        #将本文件放置于natapp同级目录 程序将读取 [default] 段
        #在命令行参数模式如 natapp -authtoken=xxx 等相同参数将会覆盖掉此配置
        #命令行参数 -config= 可以指定任意config.ini文件
        [default]
        authtoken=                      #对应一条隧道的authtoken
        clienttoken=                    #对应客户端的clienttoken,将会忽略authtoken,若无请留空,
        log=none                        #log 日志文件,可指定本地文件, none=不做记录,stdout=直接屏幕输出 ,默认为none
        loglevel=ERROR                  #日志等级 DEBUG, INFO, WARNING, ERROR 默认为 DEBUG
        http_proxy=                     #代理设置 如 http://10.123.10.10:3128 非代理上网用户请务必留空
    8、配置文件中只用配置一下  authtoken 这个在购买的隧道中有，可以在我的隧道中查看 
    动exe文件即可启动内网穿透 查看将什么网址映射到本机的127.0.0.1:80
    9、注意 因为是免费的所以映射网址会经常变

