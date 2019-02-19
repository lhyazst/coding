package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.Sms;

/**
 * @Description 验证码
 * @author:wangdi
 * @date:2019/1/15
 * @ver:1.0
 */
public interface SmsMapper extends BaseMapper<Sms> {


    Sms selectPhone(String phone);
}
