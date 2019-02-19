package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.exception.CommonCode;
import com.zeus.service.AppointmentRecycleSiteService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * @Description 预约站点
 * @Author wangdi
 * @Date 1/8/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/appointmentrecyclesite/customer/")
public class AppointmentRecycleSiteController {
    @Autowired
    private AppointmentRecycleSiteService appointmentRecycleSiteService;


    /**
     * @param [url, date]
     * @return com.zeus.common.Response
     * @methodName AppointmentRecycleSiteAdd  用户填写预约上门时间
     * @author wangdi
     * @date 2019/1/11
     */
    @PostMapping("appointmentrecyclesite/{url}/{date}/{username}")
    @ResponseBody
    public Response appointmentRecycleSiteAdd(@PathVariable("url") String url, @PathVariable("date") Date date, @PathVariable("username") String userId) {
        if (EmptyUtil.isEmpty(url) && EmptyUtil.isEmpty(date)) {
            new QueryResponseResult<>(CommonCode.INVALID_PARAM, null);
        }
        Response response = appointmentRecycleSiteService.appointmentRecycleSiteAdd(url, date, userId);
        return response;
    }


}
