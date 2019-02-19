package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.ArticleStdmode;

import java.util.List;
/**
 * @Description
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
public interface ArticleStdmodeMapper extends BaseMapper<ArticleStdmode> {

    /**
     *
     *
     * @methodName  warehousearticleFanAll 查询出所有的物品分类
     * @author wangdi
     * @param []
     * @return java.util.List<com.zeus.entity.ArticleStdmode>
     * @date 2019/1/21
     */
    List<ArticleStdmode> warehousearticleFanAll();

}