package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;

import com.zeus.exception.CommonCode;
import com.zeus.service.ActivityUserService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description 活动参与用户
 *
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/activityUser/page/")
public class ActivityUserController {
    @Autowired
    private ActivityUserService activityUserService;

    /**
     *
     *
     * @methodName  activityUser  查询出此活动所有的参与人员
     * @author wangdi
     * @param []
     * @return com.zeus.common.Response
     * @date 2019/1/3
     */
    @GetMapping("activityUser/{id}")
    @ResponseBody
    private QueryResponseResult activityUser(@PathVariable("id") Long id) {
        if (EmptyUtil.isEmpty(id)) {
          return  new QueryResponseResult(CommonCode.INVALID_PARAM,null);
        }
       QueryResponseResult courseResponse = activityUserService.activityUserserviceFandOne(id);

        return courseResponse;
    }








}
