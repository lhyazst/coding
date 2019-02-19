package com.zeus.service;

import com.zeus.common.QueryResponseResult;
import com.zeus.entity.EcsAccountLog;
import com.zeus.entity.Users;

/**
 * @Description 用户表回收日志
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
public interface UsersLogService {


    QueryResponseResult userLogFanAll(String username);
}
