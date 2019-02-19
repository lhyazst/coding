package com.zeus.dao;

import com.zeus.entity.Role;
import com.zeus.entity.Users;
import com.zeus.entity.Warehouse;
import com.zeus.entity.WorkUsers;


import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WorkUsersMapper {
   /**
    *
    *
    * @methodName  findByUsername  用户登陆
    * @author wangdi
    * @param [phone]
    * @return com.zeus.entity.WorkUsers
    * @date 2019/1/17
    */
    @Select("select * from work_users where phone=#{phone}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "status", column = "status"),
            @Result(property = "money", column = "money"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.zeus.dao.RoleMapper.findRoleByUserId"))
    })
    public  WorkUsers findByUsername(String phone) throws Exception;
   /**
    *
    *
    * @methodName  selectuserName  更具用户名查询出唯一用户
    * @author wangdi
    * @param [username]
    * @return com.zeus.entity.WorkUsers
    * @date 2019/1/17
    */
    WorkUsers selectuserName(String username);

    /**
     *
     *
     * @methodName  updateByPrimaryKey  更改回收员金额
     * @author wangdi
     * @param [workUsers]
     * @return void
     * @date 2019/1/19
     */
    void updateByPrimaryKey(WorkUsers workUsers);

    Users Login(@Param("username") String username,@Param("password") String password);
    Role LoginOfRole(@Param("id") Long id);
}