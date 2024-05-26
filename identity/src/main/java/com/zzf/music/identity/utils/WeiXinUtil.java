package com.zzf.music.identity.utils;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 微信登录工具类
 *
 * @author
 * @date 2023/11/1 15:28
 */
public class WeiXinUtil {

    private static final String appId = "wx019fe0df77a21a50";
    private static final String appsecret = "946085ec164c7cbd1f0781269a2470a0";
    private static final String getCodeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize";
    private static final String redirectUrl = "http://192.144.239.113/verify/getAccessToken";
    private static final String getAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
    private static final String refreshTokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
    private static final String getUserInfo = "https://api.weixin.qq.com/sns/userinfo";

    /**
     * 获取微信授权code
     * @param state 附加信息
     * @return
     */
    public static String getCode(String state) {
        try {
            StringBuffer url = new StringBuffer();
            url.append("redirect:")
                    .append(getCodeUrl)
                    .append("?appid=")
                    .append(appId)
                    .append("&redirect_uri=")
                    .append(URLEncoder.encode(redirectUrl, "UTF-8"))
                    .append("&response_type=code&scope=snsapi_userinfo&state=")
                    .append(state)
                    .append("#wechat_redirect");
            return url.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("URL格式化异常");
        }

    }

    /**
     * 获取微信AccessToken
     * @param code 用户code
     * @return
     */
    public static Map<?, ?> getAccessToken(String code) {
        StringBuffer url = new StringBuffer();
        url.append(getAccessTokenUrl)
                .append("?appid=")
                .append(appId)
                .append("&secret=")
                .append(appsecret)
                .append("&code=")
                .append(code)
                .append("&grant_type=authorization_code");
        String rs = HttpUtil.get(url.toString());
        Map map = JSONObject.parseObject(rs, Map.class);
        if (null == map.get("errcode")) {
            return map;
        } else {
            throw new RuntimeException("获取access_token出错");
        }
    }

    /**
     * 刷新AccessToken
     * @param refreshToken
     * @return
     */
    public static Map refreshToken(String refreshToken) {
        StringBuffer url = new StringBuffer();
        url.append(refreshTokenUrl)
                .append("?appid=")
                .append(appId)
                .append("&grant_type=refresh_token&refresh_token=")
                .append(refreshToken);
        String rs = HttpUtil.get(url.toString());
        Map map = JSONObject.parseObject(rs, Map.class);
        if (null == map.get("errcode")) {
            return map;
        } else {
            throw new RuntimeException("刷新access_token出错");
        }
    }

    /**
     * 获取用户信息
     * @param accessToken
     * @param openid
     * @return
     */
    public static String getUserInfo(String accessToken, String openid) {
        StringBuffer url = new StringBuffer();
        url.append(getUserInfo)
                .append("?access_token=")
                .append(accessToken)
                .append("&openid=")
                .append(openid)
                .append("&lang=zh_CN");
        String rs = HttpUtil.get(url.toString());
        return rs;
    }
}