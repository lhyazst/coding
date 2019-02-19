package com.zeus.service;

import com.zeus.common.QueryResponseResult;
import com.zeus.entity.EcsAccountLog;
import com.zeus.entity.Users; /**
 * @Description 用户表的操作
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
public interface UsersService {

    /**
     * 发送短信验证码
     * @param phone
     */
    public void createSmsCode(String phone);

    /**
     * 校验验证码
     * @param phone
     * @param code
     * @return
     */
    public boolean checkSmsCode(String phone,String code);



    /**
     *
     *
     * @methodName  add 添加用户基本信息
     * @author wangdi
     * @param [user]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/16
     */
    QueryResponseResult add(Users user,String phone);
   /**
    *
    *
    * @methodName  fanOne 查询出唯用户名的用户
    * @author wangdi
    * @param [username]
    * @return com.zeus.entity.Users
    * @date 2019/1/15
    */

    EcsAccountLog fanOne(String username);

   /**
    *
    *
    * @methodName  userfandOne  查询用户信息
    * @author wangdi
    * @param []
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/27
    */
    QueryResponseResult userfandOne(String username);


}
