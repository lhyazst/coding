package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.service.ActivityProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description 活动
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/activityproduct/page/")
public class ActivityProductController {
    @Autowired
    private ActivityProductService activityProductService;

    /**
     * @param []
     * @return com.zeus.common.Response
     * @methodName activityProduct  跟据活动站点查询所有审核为1的活动和地址
     * @author wangdi
     * @date 2019/1/3
     */
    @GetMapping("activityproduct")
    @ResponseBody
    private QueryResponseResult activityProduct() {

        QueryResponseResult courseResponse = activityProductService.activityproductserviceFandAll();

        return courseResponse;
    }


}
