package com.zeus.dao;

import com.zeus.entity.Role;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {
    @Select("select * from role where id in (select roleId from work_users_role where userId=#{userId})")
    public List<Role> findRoleByUserId(String userId) throws Exception;

}