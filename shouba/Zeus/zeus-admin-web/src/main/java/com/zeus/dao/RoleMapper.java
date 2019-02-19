package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role>{
    @Select("select * from role where id in (select roleId from work_users_role where userId=#{userId})")
    public List<Role> findRoleByUserId(String userId) throws Exception;

   /**
    *
    *
    * @methodName  selectRole  更具id查询出用户角色
    * @author wangdi
    * @param [id]
    * @return java.util.List<com.zeus.entity.Role>
    * @date 2019/1/28
    */
   @Select("select * from role where id in (select roleId from work_users_role where userId=#{userId})")
    List<Role> selectRole(Long userId);
  /**
   *
   *
   * @methodName  selectRoleName  通过权限名查询权限
   * @author wangdi
   * @param [roleName]
   * @return com.zeus.entity.Role
   * @date 2019/1/28
   */
    Role selectRoleName(String roleName);

}