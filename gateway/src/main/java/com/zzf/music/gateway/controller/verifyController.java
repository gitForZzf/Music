package com.zzf.music.gateway.controller;

import com.alibaba.fastjson2.JSONObject;
import com.zzf.music.gateway.entity.WXUser;
import com.zzf.music.gateway.utils.WeiXinUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("verify")
public class verifyController {

    @RequestMapping(value = "/NWCTtest", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String test() {
        System.out.println("内网穿透成功");
        return "内网穿透成功";
    }

    @ResponseBody
    @GetMapping("/weChatVerifyToken")
    public String verifyToken(HttpServletRequest request) {
        System.out.println("微信token验证成功");
        System.out.println(request.getParameter("echostr"));
        return request.getParameter("echostr");
    }

    @GetMapping("/getCode")
//    @ApiOperation("获取微信code")
    public String weiXinLogin(@RequestParam(defaultValue = "zzf") String state) {
        System.out.println("调用getCode接口成功");
        System.out.println(WeiXinUtil.getCode(state));
        return WeiXinUtil.getCode(state);
    }

    @ResponseBody
    @GetMapping("/getAccessToken")
//    @ApiOperation("获取token")
    public String getAccessToken(@RequestParam String code) {
        Map result = WeiXinUtil.getAccessToken(code);
        String accessToken = result.get("access_token").toString();
        String refreshToken = result.get("refresh_token").toString();
        String openid = result.get("openid").toString();
        WXUser wxUser = new WXUser();
        wxUser.setAccessToken(accessToken);
        wxUser.setRefreshToken(refreshToken);
        wxUser.setCreateTime(new Date());
        wxUser.setUserId(1L);
        wxUser.setOpenid(openid);
//        wxUserService.save(wxUser);
        System.out.println(wxUser);
        String userInfoJsom = WeiXinUtil.getUserInfo(accessToken, openid);
        WXUser userInfo = JSONObject.parseObject(userInfoJsom, WXUser.class);
        System.out.println(userInfoJsom);
        return "<h1><b>" + userInfo.getNickname() + "<img src=\"" + userInfo.getHeadimgurl() + "\" alt=\"用户头像\"></b>看样子成功了,没你事了退下吧</h1>";
    }
}
