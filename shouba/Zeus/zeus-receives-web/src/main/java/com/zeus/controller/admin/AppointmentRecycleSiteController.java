package com.zeus.controller.admin;


import com.zeus.common.QRCodeUrl;
import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.constant.Constants;
import com.zeus.service.AppointmentRecycleSiteService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Description 预约站点
 * @Author wangdi
 * @Date 1/8/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/appointmentrecyclesite/page/")
public class AppointmentRecycleSiteController {
    @Autowired
    private AppointmentRecycleSiteService appointmentRecycleSiteService;

    /**
     * @param []
     * @return com.zeus.common.Response
     * @methodName recycleSiteFandAll  查询出所有没有回收的预约袋 并且更具小区名字来进行判断
     * @author wangdi
     * @date 2019/1/3
     */
    @GetMapping("appointmentrecyclesite/{sitename}")
    @ResponseBody
    private QueryResponseResult appointmentRecycleSiteServiceAll(@PathVariable("sitename")String siteName) {
        if(siteName==null || "".equals(siteName) || siteName.length() <1 || Constants.NULL_STRING.equals(siteName)){
            //更具最新时间查询小区

            siteName =  appointmentRecycleSiteService.siteName();
        }
            QueryResponseResult queryResponseResult= appointmentRecycleSiteService.appointmentRecycleSiteServiceFandAll(siteName);

        return queryResponseResult;
    }

    /**
     * @param [userId]
     * @return com.zeus.common.Response
     * @methodName appointmentRecycleSiteparticulars, 预约回收袋详情展示的方法并生产二维码和编号
     * @author wangdi
     * @date 2019/1/8
     */
    @GetMapping("appointmentrecyclesiteuserid/{userId}")
    @ResponseBody
    private Response appointmentRecycleSiteparticulars(@PathVariable("userId") Long userId) {
        if (EmptyUtil.isEmpty(userId)) {
            throw new IllegalArgumentException();
        }
        Response response = appointmentRecycleSiteService.appointmentRecycleSiteServicefanOne(userId);
        return response;

    }


    /**
     * @param [userId]
     * @return com.zeus.common.Response
     * @methodName appointmentRecycleSiteparticulars, 预约回收袋回收的方法存入二维码和存储回收袋
     * @author wangdi
     * @date 2019/1/8
     */

    @RequestMapping("/appointmentrecyclesiteadd/{userId}")
    @ResponseBody
    private Boolean appointmentRecycle(@RequestBody QRCodeUrl qrCodeUrl, @PathVariable("userId") Long userId) {
        if (EmptyUtil.isEmpty(userId) && EmptyUtil.isEmpty(qrCodeUrl)) {
            throw new IllegalArgumentException();
        }
        Boolean response = appointmentRecycleSiteService.appointmentRecycle(qrCodeUrl, userId);
        return response;

    }


}
