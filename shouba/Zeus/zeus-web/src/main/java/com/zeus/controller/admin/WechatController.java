package com.zeus.controller.admin;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.net.URLEncoder;

/**
 * @Description
 * @author:wangdi
 * @date:2019/1/10
 * @ver:1.0
 */

@Controller
//@RequestMapping("/wechat")
public class WechatController {
/*
 @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        //1.配置
        //2.调用方法
        String url = "http://localhost:8080/wechat/userInfo";
        String resultUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl));

        return "redirect:" + resultUrl;

    }

    @GetMapping("/userInfo")
    public String UserInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl
    ) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();

        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:" + returnUrl + "?openId=" + openId;

    }
*/


}