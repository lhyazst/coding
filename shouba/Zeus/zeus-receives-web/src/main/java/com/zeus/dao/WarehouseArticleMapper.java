package com.zeus.dao;


import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.WarehouseArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehouseArticleMapper extends BaseMapper<WarehouseArticle>{
   /**
    *
    *
    * @methodName  warehousearticleFanAll 查询出所有的仓库物品种类
    * @author wangdi
    * @param []
    * @return java.util.List<com.zeus.entity.WarehouseArticle>
    * @date 2019/1/22
    */
    List<WarehouseArticle> warehousearticleFanAll();

}