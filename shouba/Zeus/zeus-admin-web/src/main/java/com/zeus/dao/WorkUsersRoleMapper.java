package com.zeus.dao;


import java.util.List;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.WorkUsersRoleKey;
import org.apache.ibatis.annotations.Param;
/**
 * @Description 权限和用户中间表
 * @Author wangdi
 * @Date 17/12/2018 16:39
 * @Version V1.0
 */
public interface WorkUsersRoleMapper extends BaseMapper<WorkUsersRoleKey>{
  /**
   *
   *
   * @methodName  update  更改用户权限
   * @author wangdi
   * @param [id, id1]
   * @return void
   * @date 2019/1/29
   */
    void update(@Param("userid") Long userid,@Param("roleid") Long roleid);
}