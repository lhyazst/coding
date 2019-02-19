package com.zeus.dao;


import java.util.List;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.WarehouseArticleLog;
import org.apache.ibatis.annotations.Param;

public interface WarehouseArticleLogMapper extends BaseMapper<WarehouseArticleLog> {
   /**
    *
    *
    * @methodName  selectWarehouse  查询出当天统计的金额和重量
    * @author wangdi
    * @param [id, date]
    * @return java.util.List<com.zeus.entity.WarehouseArticleLog>
    * @date 2019/1/19
    */
    List<WarehouseArticleLog> selectWarehouse(@Param("id") Long id,@Param("date") String date);
   /**
    *
    *
    * @methodName  selectWarehouseFanAll  查询出当天所有的金额和重量
    * @author wangdi
    * @param []
    * @return java.util.List<com.zeus.entity.WarehouseArticleLog>
    * @date 2019/1/19
    */
    List<WarehouseArticleLog> selectWarehouseFanAll();


    List<WarehouseArticleLog> selectWarehouseName(String articleName);
    /**
     *
     *
     * @methodName  selectWarehouseUserName  计算出当天的物品总重量
     * @author wangdi
     * @param [articleName, date]
     * @return java.util.List<com.zeus.entity.WarehouseArticleLog>
     * @date 2019/1/22
     */

    List<WarehouseArticleLog> selectWarehouseUserName(@Param("articleName") String articleName, @Param("date") String date);
}