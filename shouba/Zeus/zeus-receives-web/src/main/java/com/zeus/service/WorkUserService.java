package com.zeus.service;

import com.zeus.entity.Role;
import com.zeus.entity.Users;
import com.zeus.entity.WorkUsers;
import org.apache.ibatis.annotations.Param;

/**
 * @Description  工作人员表
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
public interface WorkUserService  {
    WorkUsers selectUsername(String username);

    Users Login(String username,String password);
    Role LoginOfRole(Long id);
}
