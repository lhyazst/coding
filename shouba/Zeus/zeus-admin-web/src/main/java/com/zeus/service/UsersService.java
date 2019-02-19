package com.zeus.service;

import com.zeus.common.QueryResponseResult;
import com.zeus.entity.EcsAccountLog;
import com.zeus.entity.Users;

import java.text.ParseException;
import java.util.Map;

/**
 * @Description 用户表的操作
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
public interface UsersService {

  /**
   *
   *
   * @methodName  selectFanAll 查询出所有的用户
   * @author wangdi
   * @param []
   * @return com.zeus.common.QueryResponseResult
   * @date 2019/1/23
   */
   Map selectFanAll(Integer page, Integer size);

  /**
   *
   *
   * @methodName  deleteUserId 删除用户信息
   * @author wangdi
   * @param [id]
   * @return java.util.Map
   * @date 2019/1/24
   */
    Map deleteUserId(Long id);
   /**
    *
    *
    * @methodName  updateId 跟据id查询出唯一的对象
    * @author wangdi
    * @param [id]
    * @return java.util.Map
    * @date 2019/1/25
    */
    Map fandOne(Long id) ;

    Map updateByPrimaryKeySelective(Users users);
}
