package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.Users;

import java.util.List;

/**
 * @Description 用户表操作接口
 * @Author wangdi
 * @Date 17/12/2018 16:39
 * @Version V1.0
 */
public interface UsersMapper extends BaseMapper<Users> {
    /**
     * @param [id]
     * @return java.util.List<com.zeus.entity.Users查询出参与此活动的所有用户
     * @methodName usfandAll
     * @author wangdi
     * @date 2019/1/16
     */
    List<Users> usfandAll(Long id);

    /**
     * @param [username]
     * @return com.zeus.entity.Users
     * @methodName selectByName
     * @author wangdi
     * @date 2019/1/16
     */
    Users selectByName(String username);

    /**
     * @param [userId]
     * @return com.zeus.entity.Users
     * @methodName selectactivityUser
     * @author wangdi
     * @date 2019/1/16
     */
    Users selectactivityUser(Long userId);

   /**
    *
    *
    * @methodName  userAddressfandAll  查询出所有的用户下以及用户所在的城市
    * @author wangdi
    * @param []
    * @return java.util.List<com.zeus.entity.Users>
    * @date 2019/1/24
    */
    List<Users> userAddressfandAll();


}