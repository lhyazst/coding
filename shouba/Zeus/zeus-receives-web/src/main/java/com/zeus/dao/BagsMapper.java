package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.Bags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 回收袋操作接口
 * @Author wangdi
 * @Date 1/7/2019 23:30
 * @Version V1.0
 */
public interface BagsMapper extends BaseMapper<Bags> {

    Bags selecttow(@Param("userid") Long userId, @Param("orcNumber") Long orcNumber);

    /**
     * @param [id]
     * @return void
     * @methodName updateBagsStatus 修改状态
     * @author wangdi
     * @date 2019/1/18
     */
    void updateBagsStatus(Long id);

    /**
     * @param [id]
     * @return com.zeus.entity.Bags
     * @methodName selectorcid 跟据二维码id查询出回收袋
     * @author wangdi
     * @date 2019/1/18
     */
    Bags selectorcid(Long id);

    /**
     * @param [id]
     * @return void
     * @methodName updateworkUsersStatus  回收员更改回收袋状态为2
     * @author wangdi
     * @date 2019/1/18
     */
    void updateworkUsersStatus(Long id);

    /**
     * @param [id]
     * @return java.util.List<com.zeus.entity.Bags>
     * @methodName selectusersbags  通过二维码的id查询出回收袋
     * @author wangdi
     * @date 2019/1/18
     */
    Bags selectusersbags(Long userid);


    /**
     * @param [date, id]
     * @return java.util.List<com.zeus.entity.Bags>
     * @methodName warehousebagsFanAll  查询出该仓库下的所有还未分炼回收袋
     * @author wangdi
     * @date 2019/1/18
     */
    List<Bags> warehousebagsFanAll(@Param("date") String date, @Param("id") Long id);

    /**
     * @param [date, id]
     * @return java.util.List<com.zeus.entity.Bags>
     * @methodName warehousebagsFanAll  查询出该仓库下的所有已经分炼回收袋
     * @author wangdi
     * @date 2019/1/18
     */
    List<Bags> warehousebagsOkFanAll(@Param("date") String date, @Param("id") Long id);

}