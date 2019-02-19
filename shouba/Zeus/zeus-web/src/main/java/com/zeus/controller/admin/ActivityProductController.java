package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.entity.ActivityProduct;
import com.zeus.exception.CommonCode;
import com.zeus.service.ActivityProductService;
import com.zeus.utils.EmptyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Description 活动
 *
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/activityproduct/page/")
public class ActivityProductController {
    @Autowired
    private ActivityProductService activityProductService;

    private static  final Logger LOGGER = LoggerFactory.getLogger(ActivityProductController.class);

    /**
     *
     *
     * @methodName  GoodsFandAll 查询出所有活动跟据时间和状态为1
     * @author wangdi
     * @param []
     * @return com.zeus.common.Response
     * @date 2019/1/3
     */
    @GetMapping("activityproduct")
    @ResponseBody
    private QueryResponseResult activityProductfand() {

        List<ActivityProduct> courses = activityProductService.activityproductserviceFandAll();

        if (EmptyUtil.isEmpty(courses )) {
            LOGGER.error("查询活动数据为空:{}",courses);
           return new QueryResponseResult(CommonCode.DATA_NOT_FOUND,null);
        }
        QueryResult<Object> objectQueryResult = new QueryResult<>();
        objectQueryResult.setT(courses);
        return new QueryResponseResult(CommonCode.SUCCESS,objectQueryResult);
    }


}
