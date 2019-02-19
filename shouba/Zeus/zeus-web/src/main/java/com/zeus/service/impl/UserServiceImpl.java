package com.zeus.service.impl;

import com.zeus.dao.UserMapper;
import com.zeus.entity.User;
import com.zeus.service.IUserService;
import com.zeus.utils.ArithmeticUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 用户操作服务实现类
 * @Author 元稹
 * @Date 16/12/2018 21:57
 * @Version V1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User find(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
