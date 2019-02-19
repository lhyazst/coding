package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.Orc;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @Description 二维码
 * @Author wangdi
 * @Date 1/8/2019 23:30
 * @Version V1.0
 */
public interface OrcMapper extends BaseMapper<Orc> {
    /**
     *
     *
     * @methodName  selectOrcNumber
     * @author wangdi
     * @param [num, userId]
     * @return java.util.List<com.zeus.entity.Orc>
     * @date 2019/1/14
     */
    List<Orc> selectOrcNumber(@Param("num") Long num, @Param("userId") Long userId);
   /**
    *
    *
    * @methodName  oubFandOne
    * @author wangdi
    * @param [userId, number, userId1]
    * @return com.zeus.entity.Orc
    * @date 2019/1/14
    */
    Orc oubFandOne(@Param("uid1") Long userId, @Param("number") Long number, @Param("uid2") Long userId1);

   /**
    *
    *
    * @methodName  selectByOrcNum  通过编号获取orc
    * @author wangdi
    * @param [num]
    * @return com.zeus.entity.Orc
    * @date 2019/1/14
    */
    Orc selectByOrcNum(Long num);
    void updateBinStatus(Long id);
}