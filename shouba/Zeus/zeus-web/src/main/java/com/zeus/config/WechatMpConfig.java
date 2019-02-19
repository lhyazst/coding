package com.zeus.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @author:wangdi
 * @date:2019/1/9
 * @ver:1.0
 */
@Component
@PropertySource("classpath:weixinpay.properties")
public class WechatMpConfig {

/*

   @Value("${mpAppid}")
    public String mpAppid;
    @Value("${mpAppSecret}")
    public String mpAppSecret;

    @Bean
    public WxMpService wxMpService() {

        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(mpAppid);
        wxMpConfigStorage.setSecret(mpAppSecret);
        return wxMpConfigStorage;
    }
*/



}
