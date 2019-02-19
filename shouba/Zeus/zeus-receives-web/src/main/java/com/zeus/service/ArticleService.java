package com.zeus.service;



import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.commons.Articles;
import com.zeus.entity.Article;


/**
 * @Description 物品操作服务层
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface ArticleService {

  /**
   *
   *
   * @methodName  add 回收员添加活动物品回收，并将物品状态修改为1
   * @author wangdi
   * @param [articles, username]
   * @return com.zeus.common.QueryResponseResult
   * @date 2019/1/18
   */
   QueryResponseResult add(Articles articles,String username);
   /**
    *
    *
    * @methodName  fanAll
    * @author wangdi
    * @param []
    * @return com.zeus.common.Response
    * @date 2019/1/21
    */
    Response fanAll();

    void add1(Article article);
   /**
    *
    *
    * @methodName  warehouseArticleAdd
    * @author wangdi
    * @param [articles, username, orcid, pricenum]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/18
    */

    QueryResponseResult warehouseArticleAdd(Articles articles, String username,Long orcid,String pricenum,String type);
}
