package com.zeus.service;



import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.commons.Articles;
import com.zeus.entity.Article;
import com.zeus.entity.ArticleStdmode;

import java.util.List;


/**
 * @Description 物品种类操作服务层
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface ArticleStdmodeService {

    List<ArticleStdmode> articleStdmodesList();

}
