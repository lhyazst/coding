package com.zeus.service;


import com.zeus.common.QRCodeUrl;
import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;

/**
 * @Description  预约回收站点操作服务层
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface AppointmentRecycleSiteService {




  QueryResponseResult appointmentRecycleSiteServiceFandAll(String siteName);

    Response appointmentRecycleSiteServicefanOne(Long userId);

    Boolean appointmentRecycle(QRCodeUrl qrCodeUrl, Long userId);

    String siteName();

}
