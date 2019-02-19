package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;

import com.zeus.service.RecycleSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @Description 回收站点
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/recycleSite/page/")
public class RecycleSiteController {
    @Autowired
    private RecycleSiteService recycleSiteService;

    /**
     * @param []
     * @return com.zeus.common.Response
     * @methodName recycleSiteFandAll  查询出所有的回收站站点
     * @author wangdi
     * @date 2019/1/3
     */
    @GetMapping("recycleSitefandall")
    @ResponseBody
    private QueryResponseResult recycleSiteFandAll() {

      QueryResponseResult response = recycleSiteService.recycleStieFandAll();

        return response;
    }


}
