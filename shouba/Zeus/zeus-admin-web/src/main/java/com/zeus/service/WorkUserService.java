package com.zeus.service;

import com.zeus.entity.WorkUsers;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

/**
 * @Description 工作人员表
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
public interface WorkUserService extends UserDetailsService {


   /* *//**
     * @param [username]
     * @return com.zeus.entity.WorkUsers
     * @methodName selectUsername  登陆
     * @author wangdi
     * @date 2019/1/24
     *//*
    WorkUsers selectUsername(String username);*/

    /**
     * @param [username]
     * @return com.zeus.entity.WorkUsers
     * @methodName selectUsername  登陆
     * @author xiaoxuanfeng
     * @date 2019/2/15
     */

    WorkUsers IsLogin(String username,String password);

    /**
     * @param [page, size]
     * @return com.zeus.common.QueryResponseResult
     * @methodName selectFanAll 查询所有工作人员用户
     * @author wangdi
     * @date 2019/1/24
     */
    Map selectFanAll(Integer page, Integer size);

    /**
     * @param [id]
     * @return java.util.Map
     * @methodName deleteWorkUsersFandOne  跟据用户id删除用户
     * @author wangdi
     * @date 2019/1/28
     */

    Map deleteWorkUsersFandOne(Long id);
   /**
    *
    *
    * @methodName  addWorkUser  添加用户信息
    * @author wangdi
    * @param [workUsers]
    * @return java.util.Map
    * @date 2019/1/28
    */
    Map addWorkUser(WorkUsers workUsers);
   /**
    *
    *
    * @methodName  fandOne 跟据id查询对象
    * @author wangdi
    * @param [id]
    * @return java.util.Map
    * @date 2019/1/29
    */
    Map fandOne(Long id);
    /**
     *
     *
     * @methodName  updateUsers 用户更改信息
     * @author wangdi
     * @param [workUsers]
     * @return java.util.Map
     * @date 2019/1/29
     */
    Map updateUsers(WorkUsers workUsers);

}
