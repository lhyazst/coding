package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.entity.WarehouseArticle;
import com.zeus.exception.CommonCode;
import com.zeus.service.WarehouseArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Description 仓库录入物品种类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/warehousearticle/page/")
public class WarehouseArticleController {

    @Autowired
    private WarehouseArticleService warehouseArticleService;

    /**
     * @param []
     * @return com.zeus.common.QueryResponseResult
     * @methodName warehouseArticleStdmode 查询出所有的仓库物品种类
     * @author wangdi
     * @date 2019/1/19
     */
    @GetMapping("warehousearticle")
    @ResponseBody
    public QueryResponseResult warehouseArticleStdmode() {

        List<WarehouseArticle> warehousearticle = warehouseArticleService.warehousearticleFanAll();
        QueryResult<Object> objectQueryResult = new QueryResult<>();

        objectQueryResult.setT(warehousearticle);
        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
    }





}
