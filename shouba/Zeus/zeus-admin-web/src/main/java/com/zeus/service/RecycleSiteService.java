package com.zeus.service;


import com.zeus.common.QueryResponseResult;

import java.util.Map;

/**
 * @Description  回收站点操作服务层
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface RecycleSiteService {

    /**
     *
     *
     * @methodName  recycleStieFandAll 查询出所有的站点
     * @author wangdi
     * @param []
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/30
     */
    Map recycleStieFandAll(Integer page, Integer size);
     /**
      *
      *
      * @methodName  recycleSiteDelete 删除站点
      * @author wangdi
      * @param [id]
      * @return java.util.Map
      * @date 2019/1/30
      */
    Map recycleSiteDelete(Long id);
}
