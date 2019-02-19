package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.commons.Articles;
import com.zeus.dao.*;
import com.zeus.entity.*;
import com.zeus.exception.CommonCode;
import com.zeus.service.ArticleService;
import com.zeus.service.EcsAccountLogService;
import com.zeus.service.WarehouseArticleService;
import com.zeus.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description 仓库物品操作服务层
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class WarehouseArticleServiceImpl implements WarehouseArticleService {
     @Autowired
    private WarehouseArticleMapper warehouseArticleMapper;

     /**
      *
      *
      * @methodName  warehousearticleFanAll  查询出仓库的所有物品种类
      * @author wangdi
      * @param []
      * @return java.util.List<com.zeus.entity.WarehouseArticle>
      * @date 2019/1/19
      */
    @Override
    public List<WarehouseArticle> warehousearticleFanAll() {

      List<WarehouseArticle>  warehouseArticles =  warehouseArticleMapper.warehousearticleFanAll();

        return warehouseArticles;

    }
}
