package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.Address;
import com.zeus.entity.AppointmentRecycleSite;

import java.util.List;

/**
 *
 *
 * @methodName   预约回收站点
 * @author wangdi
 * @param
 * @return
 * @date 2019/1/10
 */
public interface AppointmentRecycleSiteMapper extends BaseMapper<AppointmentRecycleSite> {
     /**
      *
      *
      * @methodName  recycleSiteFandAll  更具小区名称查询出所有的预约站点
      * @author wangdi
      * @param [username]
      * @return java.util.List<com.zeus.entity.AppointmentRecycleSite>
      * @date 2019/1/18
      */
    List<AppointmentRecycleSite> recycleSiteFandAll(String sitename);
    /**
     *
     *
     * @methodName  recycleSiteFandAll  查询出所有有预约的用户小区名称
     * @author wangdi
     * @param [username]
     * @return java.util.List<com.zeus.entity.AppointmentRecycleSite>
     * @date 2019/1/18
     */
    List<Address> recycleSiteAddressFandAll();

}