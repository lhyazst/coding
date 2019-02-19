package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.ArticleStdmode;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleStdmodeMapper extends BaseMapper<ArticleStdmode> {
    /**
     *
     *
     * @methodName  warehousearticleFanAll 查询出所有物品种类
     * @author wangdi
     * @param []
     * @return java.util.List<com.zeus.entity.ArticleStdmode>
     * @date 2019/1/21
     */
    List<ArticleStdmode> warehousearticleFanAll();

}