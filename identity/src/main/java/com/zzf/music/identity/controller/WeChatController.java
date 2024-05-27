package com.zzf.music.identity.controller;

import com.alibaba.fastjson2.JSONObject;
import com.zzf.music.identity.entity.WXUser;
import com.zzf.music.identity.utils.WeiXinUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/weChat")
public class WeChatController {

    @ResponseBody
    @GetMapping("/verifyToken")
    @ApiOperation("微信Token验证")
    public String verifyToken(HttpServletRequest request) {
        return request.getParameter("echostr");
    }

    @GetMapping("/getCode")
    @ApiOperation("获取微信code")
    public String weiXinLogin(@RequestParam(defaultValue = "zzf") String state) {
        System.out.println("调用getCode接口成功");
        return WeiXinUtil.getCode(state);
    }

    @ResponseBody
    @GetMapping("/getAccessToken")
    @ApiOperation("获取token")
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
        String userInfoJsom = WeiXinUtil.getUserInfo(accessToken, openid);
        System.out.println(userInfoJsom);
        return "<h1>看样子成功了,没你事了退下吧</h1>";
    }
//
//    @ResponseBody
//    @GetMapping("/refreshToken")
//    @ApiOperation("刷新token")
//    public R refreshToken() {
//        Long userId = 1L;
//        WXUser wxUser = wxUserService.getOne(new LambdaUpdateWrapper<WXUser>().eq(WXUser::getUserId, userId));
//        Map result = WeiXinUtil.refreshToken(wxUser.getRefreshToken());
//        String accessToken = result.get("access_token").toString();
//        String refreshToken = result.get("refresh_token").toString();
//        WXUser wxUserUpdate = new WXUser();
//        wxUserUpdate.setId(wxUser.getId());
//        wxUserUpdate.setAccessToken(accessToken);
//        wxUserUpdate.setRefreshToken(refreshToken);
//        wxUserUpdate.setUpdateTime(new Date());
//        wxUserService.updateById(wxUserUpdate);
//        return R.data(accessToken);
//    }
//
//    @ResponseBody
//    @GetMapping("/getUserInfo")
//    @ApiOperation("获取用户信息")
//    public void getUserInfo() {
//        Long userId = 1L;
//        WXUser wxUser = wxUserService.getOne(new LambdaUpdateWrapper<WXUser>().eq(WXUser::getUserId, userId));
//        String accessToken = wxUser.getAccessToken();
//        String openid = wxUser.getOpenid();
//        String userInfoJsom = WeiXinUtil.getUserInfo(accessToken, openid);
//        WXUser userInfo = JSONObject.parseObject(userInfoJsom, WXUser.class);
//        userInfo.setId(wxUser.getId());
//        userInfo.setUpdateTime(new Date());
//        wxUserService.updateById(userInfo);
//        return R.data(userInfo);
//    }

}