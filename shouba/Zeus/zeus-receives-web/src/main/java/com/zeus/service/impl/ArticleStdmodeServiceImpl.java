package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.commons.Articles;
import com.zeus.dao.ArticleMapper;
import com.zeus.dao.ArticleStdmodeMapper;
import com.zeus.dao.WorkUsersMapper;
import com.zeus.entity.Article;
import com.zeus.entity.ArticleStdmode;
import com.zeus.entity.WorkUsers;
import com.zeus.exception.CommonCode;
import com.zeus.service.ArticleService;
import com.zeus.service.ArticleStdmodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description  物品操作服务层
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class ArticleStdmodeServiceImpl implements ArticleStdmodeService {
  @Autowired
    private ArticleStdmodeMapper articleStdmodeMapper;


  /**
   *
   *
   * @methodName  articleStdmodesList  查询出所有的物品种类
   * @author wangdi
   * @param []
   * @return java.util.List<com.zeus.entity.ArticleStdmode>
   * @date 2019/1/18
   */
    @Override
    public List<ArticleStdmode> articleStdmodesList(){

        List<ArticleStdmode> articleStdmodes = articleStdmodeMapper.warehousearticleFanAll();

        return articleStdmodes;
    }




}
