package com.zeus.controller.admin;



import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.commons.Articles;
import com.zeus.entity.Article;
import com.zeus.exception.CommonCode;
import com.zeus.service.ArticleService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Description 物品回收
 *
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
     * @methodName  articleAdd   回收员添加活动物品回收，并将物品状态修改为1
     * @author wangdi
     * @param [articles]
     * @return java.lang.Boolean
     * @date 2019/1/10
     */
     @PostMapping("article/{phone}")
    @ResponseBody
    public QueryResponseResult articleAdd(@RequestBody Articles articles,@PathVariable("phone") String phone){

        // String username = SecurityContextHolder.getContext().getAuthentication().getName();
         if (EmptyUtil.isEmpty(articles)) {
            new QueryResponseResult<>(CommonCode.INVALID_PARAM,null);
         }
           QueryResponseResult booleans =  articleService.add(articles,phone);
      return booleans;
    }

    /**
     *
     *
     * @methodName  articleAdd  仓管员回收物品，并将物品状态修改为2，并修改二维码和回收袋的状态
     * @author wangdi
     * @param [articles]
     * @return java.lang.Boolean
     * @date 2019/1/10
     */
    @PostMapping("warehouseArticleAdd/{orcid}/{pricenum}/{type}/{phone}")
    @ResponseBody
    public QueryResponseResult warehouseArticleAdd(@RequestBody Articles articles,@PathVariable("orcid")Long orcid,@PathVariable("pricenum")String pricenum,@PathVariable("type")String type,@PathVariable("phone") String phone){

      //  String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (EmptyUtil.isEmpty(articles)) {
            new QueryResponseResult<>(CommonCode.INVALID_PARAM,null);
        }
        QueryResponseResult booleans =  articleService.warehouseArticleAdd(articles,phone,orcid,pricenum,type);
        return booleans;
    }








    /**
     *
     *
     * @methodName  fandAll  查询物品测试
     * @author wangdi
     * @param []
     * @return com.zeus.common.Response
     * @date 2019/1/10
     */
   @GetMapping("articlefandall")
   @ResponseBody
    public Response fandAll(){
        Response response = articleService.fanAll();
         return response;
    }

    /**
     *
     *
     * @methodName  add 单独插入物品数据测试
     * @author wangdi
     * @param [article]
     * @return void
     * @date 2019/1/10
     */
     @PostMapping("add")
    public void add(@RequestBody Article article){
         articleService.add1(article);
    }



}
