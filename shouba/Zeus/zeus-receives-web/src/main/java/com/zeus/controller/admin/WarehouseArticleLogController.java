package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.entity.WarehouseArticle;
import com.zeus.service.WarehouseArticleLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Description 仓库录入物品日志
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/warehousearticlelog/page/")
public class WarehouseArticleLogController {

    @Autowired
    private WarehouseArticleLogService warehouseArticleLogService;

    /**
     * @param []
     * @return com.zeus.common.QueryResponseResult
     * @methodName warehouseArticleStdmode 插入仓库物品数据
     * @author wangdi
     * @date 2019/1/19
     */
    @PostMapping("addWarehousearticlelog/{phone}")
    @ResponseBody
    public QueryResponseResult addWarehouseArticlelog(@RequestBody List<WarehouseArticle> warehouseArticleLogs ,@PathVariable("phone")String phone) {

        //String username = SecurityContextHolder.getContext().getAuthentication().getName();

        QueryResponseResult queryResponseResult = warehouseArticleLogService.addWarehouseArticlelog(warehouseArticleLogs,phone);

        return queryResponseResult;


    }

    /**
     * @param []
     * @return com.zeus.common.QueryResponseResult
     * @methodName selectWarehouseArticlelog  查询出所有统计的数据
     * @author wangdi
     * @date 2019/1/19
     */
    @GetMapping("selectWarehouseArticlelog/{phone}")
    @ResponseBody
    public QueryResponseResult selectWarehouseArticlelog(@PathVariable("phone")String phone) {

        //String username = SecurityContextHolder.getContext().getAuthentication().getName();

        QueryResponseResult queryResponseResult = warehouseArticleLogService.selectWarehouseArticlelog(phone);

        return queryResponseResult;
    }


}
