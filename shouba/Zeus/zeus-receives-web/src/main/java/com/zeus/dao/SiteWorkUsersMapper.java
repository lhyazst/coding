package com.zeus.dao;


import java.util.List;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.SiteWorkUsers;
import org.apache.ibatis.annotations.Param;
/**
 * @Description 回收员和站点记录
 * @Author wangdi
 * @Date 1/13/2019 11:30
 * @Version V1.0
 */
public interface SiteWorkUsersMapper extends BaseMapper<SiteWorkUsers>{
    Long selectSiteWorkUser(Long id);

    Long selectSiteWorkUserDate(@Param("date") String date,@Param("id") Long id);
}