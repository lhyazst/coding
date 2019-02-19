package com.zeus.service.impl;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.common.Response;
import com.zeus.dao.*;
import com.zeus.entity.*;
import com.zeus.exception.CommonCode;
import com.zeus.service.AddressService;
import com.zeus.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description 物品
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private BagsMapper bagsMapper;
    @Autowired
    private ArticleStdmodeMapper articleStdmodeMapper;

    /**
     * @param [username]
     * @return com.zeus.common.QueryResponseResult
     * @methodName articleServicefandOne  查询出环保贡献
     * @author wangdi
     * @date 2019/1/16
     */
    @Override
    public QueryResponseResult articleServicefandOne(String username) {

        Users users = usersMapper.selectByName(username);
        List<Article> articles = articleMapper.fandArticleUsers(users.getId());
        Double articleWeight = 0D;
        for (Article article : articles) {
            articleWeight += article.getArticleWeight();
        }


        List<Article> list2 = new ArrayList();
        List<ArticleStdmode> articleStdmodes = articleStdmodeMapper.warehousearticleFanAll();
        List<Article> article = null;
        //查询出该用户的物品
        for (ArticleStdmode articleStdmode : articleStdmodes) {
            double weiht = 0;
            article = articleMapper.selectName(articleStdmode.getArticleName());
            if (article == null || article.size() < 1) {
                continue;
            }
            Article article2 = new Article();
            for (Article article1 : article) {
                weiht += article1.getArticleWeight();
            }
            article2.setArticleWeight(weiht);
            article2.setArticleName(articleStdmode.getArticleName());
            list2.add(article2);
        }
        if (list2.size() > 0) {
            users.setArticles(list2);
        }

        Long bagsnum = bagsMapper.fanduserId(users.getId());

        Map map = new HashMap(16);

        map.put("articles", articles);
        map.put(" articleWeight", articleWeight);
        map.put("bagsnum", bagsnum);
        QueryResult<Object> objectQueryResult = new QueryResult<>();
        objectQueryResult.setT(map);
        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
    }
}
