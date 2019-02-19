package com.zeus.dao;


import java.util.List;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.WarehouseBags;
import org.apache.ibatis.annotations.Param;

public interface WarehouseBagsMapper extends BaseMapper<WarehouseBags> {
   /**
    *
    *
    * @methodName  selectBagUserNum  查询出包裹当天的数量
    * @author wangdi
    * @param [id, date]
    * @return java.lang.Long
    * @date 2019/1/19
    */
    Long selectBagUserNum(@Param("id") Long id,@Param("date") String date);

   /**
    *
    *
    * @methodName  selectBagNum 查询出仓管员回收过后的所有包裹
    * @author wangdi
    * @param []
    * @return java.lang.Long
    * @date 2019/1/19
    */
    Long selectBagNum();


}