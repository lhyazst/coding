package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.service.SiteWorkUsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description
 * @Author wangdi  回收员查询统计
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/siteWorkUsers/page/")
public class SiteWorkUsersController {
    @Autowired
    private SiteWorkUsersService siteWorkUsersService;


    /**
     *
     *
     * @methodName  siteWorkUsersSelect 回收员查询出回收管理里面的统计回收袋数量和站点数量
     * @author wangdi
     * @param []
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/27
     */

    @GetMapping("siteWorkUsersSelect/{phone}")
    @ResponseBody
    public QueryResponseResult siteWorkUsersSelect(@PathVariable("phone")String phone) {
        //String username = SecurityContextHolder.getContext().getAuthentication().getName();

        QueryResponseResult queryResponseResult = siteWorkUsersService.siteWorkUsersSelect(phone);
        return queryResponseResult;
    }


}
