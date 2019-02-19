package com.zeus.service.impl;

import com.zeus.dao.UsersMapper;
import com.zeus.dao.WorkUsersMapper;
import com.zeus.entity.Role;
import com.zeus.entity.Users;
import com.zeus.entity.WorkUsers;
import com.zeus.service.UsersService;
import com.zeus.service.WorkUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Description  登陆校验
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
@Service("userService")
@Transactional(rollbackFor = { Exception.class })
public class WorkUserServiceImpl implements WorkUserService{
    @Autowired
  private   WorkUsersMapper workUsersMapper;


     /**
      *
      *
      * @methodName  selectUsername 更具用户名查询出用户
      * @author wangdi
      * @param [username]
      * @return com.zeus.entity.WorkUsers
      * @date 2019/1/17
      */
    @Override
    public WorkUsers selectUsername(String username) {

       WorkUsers workUsers = workUsersMapper.selectuserName(username);

        return workUsers;

    }

    @Override
    public Users Login(String username, String password) {
        return workUsersMapper.Login(username,password);
    }

    @Override
    public Role LoginOfRole(Long id) {
        return workUsersMapper.LoginOfRole(id);
    }


}
