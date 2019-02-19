package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.Article;

import java.util.List;

/**
 *
 *
 * @methodName   物品
 * @author wangdi
 * @param
 * @return
 * @date 2019/1/10
 */
public interface ArticleMapper extends BaseMapper<Article>{
    /**
     *
     *
     * @methodName  fandArticleUsers 通过用户id查询出该用户参加活动的物品
     * @author wangdi
     * @param [userid]
     * @return java.util.List<com.zeus.entity.Article>
     * @date 2019/1/21
     */
    List<Article> fandArticleUsers(Long userid);
      /**
       *
       *
       * @methodName  selectName  跟据物品名称查询出物品
       * @author wangdi
       * @param [articleName]
       * @return com.zeus.entity.Article
       * @date 2019/1/21
       */
    List<Article> selectName(String articleName);

}