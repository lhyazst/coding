package com.zeus.dao;

import java.util.List;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.RecycleUserNum;
import org.apache.ibatis.annotations.Param;

public interface RecycleUserNumMapper extends BaseMapper<RecycleUserNum>{
  /**
   *
   *
   * @methodName  selectRecycleUserNum  查询当天的回收员数量
   * @author wangdi
   * @param [id, date]
   * @return java.util.List<com.zeus.entity.RecycleUserNum>
   * @date 2019/1/19
   */
    List<RecycleUserNum> selectRecycleUserNum(@Param("id") Long id,@Param("date") String date);
  /**
   *
   *
   * @methodName  selectRecycleNum  查询出所有的回收员数量
   * @author wangdi
   * @param []
   * @return java.util.List<com.zeus.entity.RecycleUserNum>
   * @date 2019/1/19
   */
    List<RecycleUserNum> selectRecycleNum();


}