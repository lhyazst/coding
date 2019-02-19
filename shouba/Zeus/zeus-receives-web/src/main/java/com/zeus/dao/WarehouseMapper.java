package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.Bags;
import com.zeus.entity.Warehouse;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarehouseMapper extends BaseMapper<Warehouse> {
  /**
   *
   *
   * @methodName  selectUserFandAll  查询出该仓库员管理的所有仓库
   * @author wangdi
   * @param [id]
   * @return java.util.List<com.zeus.entity.Warehouse>
   * @date 2019/1/18
   */
    List<Warehouse> selectUserFandAll(Long id);

}