package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;


import com.zeus.entity.Role;
import com.zeus.entity.WorkUsers;
import org.apache.ibatis.annotations.*;

/**
 * @Description 工作人员表
 * @Author wangdi
 * @Date 17/12/2018 16:39
 * @Version V1.0
 */
public interface WorkUsersMapper extends BaseMapper<WorkUsers>{
   /**
    *
    *
    * @methodName  findByUsername  用户登陆
    * @author wangdi
    * @param [phone]
    * @return com.zeus.entity.WorkUsers
    * @date 2019/1/17
    */
   /*@Select("select * from work_users where phone=#{phone}")
   @Results({
           @Result(id = true, property = "id", column = "id"),
           @Result(property = "username", column = "username"),
           @Result(property = "email", column = "email"),
           @Result(property = "password", column = "password"),
           @Result(property = "phone", column = "phone"),
           @Result(property = "status", column = "status"),
           @Result(property = "money", column = "money"),
           @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.zeus.dao.RoleMapper.findRoleByUserId"))
   })*/
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
    * @methodName  insertuser 添加用户
    * @author wangdi
    * @param [workUsers]
    * @return java.lang.Long
    * @date 2019/1/28
    */
    Long insertuser(WorkUsers workUsers);


    /**
     *
     *
     * @methodName  login 用户登录
     * @author xiaoxuanfeng
     * @return java.lang.Long
     * @date 2019/1/28
     */
   WorkUsers IsLogin(@Param("username") String username,@Param("password") String password);

}