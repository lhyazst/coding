package com.zeus.service;


import com.zeus.common.Response;

import java.util.Date;

/**
 * @Description  预约回收站点操作服务层
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface AppointmentRecycleSiteService {

   /**
    *
    *
    * @methodName  appointmentRecycleSiteAdd  存入用户填写的预约地址
    * @author wangdi
    * @param [url, date]
    * @return com.zeus.common.Response
    * @date 2019/1/11
    */
    Response appointmentRecycleSiteAdd(String url, Date date, String userId);
}
