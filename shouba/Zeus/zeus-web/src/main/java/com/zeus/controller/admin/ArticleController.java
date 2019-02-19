package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.exception.CommonCode;
import com.zeus.service.ArticleService;
import com.zeus.service.BagsService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Description 物品
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/article/page/")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     *
     *
     * @methodName  articleServicefandOne  查询出环保贡献
     * @author wangdi
     * @param [username]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/18
     */
    @GetMapping("articlefandone/{username}")
    @ResponseBody
    public QueryResponseResult articleServicefandOne(@PathVariable("username")String username){
        if (EmptyUtil.isEmpty(username)) {
            return new QueryResponseResult(CommonCode.INVALID_PARAM,null);
        }
        QueryResponseResult queryResponseResult = articleService.articleServicefandOne(username);
         return queryResponseResult;

    }





}
