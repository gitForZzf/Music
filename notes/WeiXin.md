## 实现微信登录

    参考 https://blog.csdn.net/LXD_CSDN/article/details/134208777
    1、微信公众平台 https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index
    2、微信登录
    3、测试号管理
    4、token 写的名字简称（为了测试） 提交url 和 域名的是否服务必须启动 微信能掉通才能提交成功
    5、url http://hs6axg.natappfree.cc/verify/weChatVerifyToken
    6、JS接口安全域名 域名 hs6axg.natappfree.cc
    7、配置网页授权获取用户基本信息 这里添加的是和域名 hs6axg.natappfree.cc 一样的内容
    8、微信登录流程
    微信客户端发送登录请求 -> 访问微信授权接口 -> 微信回调,j将授权code发送到我们的服务器 -> 通过code,appid,appsecret获取微信针对该用户的accsess_token,openid等信息-> 通过accsess_token,openid获取用户信息
    9、编写相关代码(在微信工具类中配置相关变量为 微信公众平台 中的内容)
    10、生成二维码测试功能
        (1)在微信公众平台 下方扫描公众号二维码添加用户
        (2)生成二维码 https://cli.im/text （注意选网址不要选文本）
    11、redirect_uri 域名与后台配置不一致 错误码 10003 错误处理过程
        之后经过排查是因为在 微信公众平台 上的 JS接口安全域名 和 网页授权获取用户基本信息 中填写的内容加了 http://前缀导致的
    12、测试成功 微信端返回 用户昵称 + 头像 + 自定义附加信息





