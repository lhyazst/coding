package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.Bags;
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

    List<Orc> selectOrcNumber(@Param("num") Long num, @Param("userId") Long userId);

    Orc oubFandOne(@Param("uid1") Long userId, @Param("number") Long number, @Param("uid2") Long userId1);

    void updateBinStatus(Long id);

    /**
     * @param [id]
     * @return void
     * @methodName updateworkUsersStatus  回收员更改回收袋状态为2
     * @author wangdi
     * @date 2019/1/18
     */
    void updateworkUsersStatus(Long id);

    List<Orc> selectusers(Long userid);

    /**
     * @param [date, id]
     * @return java.util.List<com.zeus.entity.Orc>
     * @methodName selectusersDate 查询出当天回收员回收的数量
     * @author wangdi
     * @date 2019/1/27
     */
    List<Orc> selectusersDate(@Param("date")String date,@Param("userid") Long userid);
}