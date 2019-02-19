package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.entity.ArticleStdmode;
import com.zeus.exception.CommonCode;
import com.zeus.service.ArticleStdmodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Description 物品种类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/articlestdmode/page/")
public class ArticleStdmodeController {

    @Autowired
    private ArticleStdmodeService articleStdmodeService;

    /**
     * @param []
     * @return com.zeus.common.QueryResponseResult
     * @methodName warehouseArticleStdmode 查询出所有的物品种类
     * @author wangdi
     * @date 2019/1/19
     */
    @GetMapping("warehouseArticleStdmode")
    @ResponseBody
    public QueryResponseResult warehouseArticleStdmode() {

        List<ArticleStdmode> articleStdmodes = articleStdmodeService.articleStdmodesList();
        QueryResult<Object> objectQueryResult = new QueryResult<>();

        objectQueryResult.setT(articleStdmodes);
        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
    }





}
