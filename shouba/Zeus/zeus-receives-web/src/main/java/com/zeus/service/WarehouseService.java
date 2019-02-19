package com.zeus.service;


import com.zeus.common.QueryResponseResult;

/**
 * @Description 仓库
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface WarehouseService {

  /**
   *
   *
   * @methodName  warehouseUserFanAll  查询出该回收员所有的仓库
   * @author wangdi
   * @param [id]
   * @return com.zeus.common.QueryResponseResult
   * @date 2019/1/18
   */
    QueryResponseResult warehouseUserFanAll(String id);
   /**
    *
    *
    * @methodName  warehousebagsFanAll  查询出该仓裤所有的回收袋
    * @author wangdi
    * @param [date]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/18
    */
    QueryResponseResult warehousebagsFanAll(String date,Long id);
   /**
    *
    *
    * @methodName  warehousefanOne  查询出该仓库的物品种类
    * @author wangdi
    * @param [id]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/19
    */
    QueryResponseResult warehousefanOne(Long id);

}
