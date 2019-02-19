package com.zeus.service.impl;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.dao.EcsAccountLogMapper;
import com.zeus.dao.SmsMapper;
import com.zeus.dao.UsersLogMapper;
import com.zeus.dao.UsersMapper;
import com.zeus.entity.EcsAccountLog;
import com.zeus.entity.Sms;
import com.zeus.entity.Users;
import com.zeus.entity.UsersLog;
import com.zeus.exception.CommonCode;
import com.zeus.service.UsersLogService;
import com.zeus.service.UsersService;
import com.zeus.sms.SmsUtil;
import org.mortbay.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 用户表的回收日志
 * @author:wangdi
 * @date:2019/1/13
 * @ver:1.0
 */
@Service
public class UsersLogServiceImpl implements UsersLogService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UsersLogMapper usersLogMapper;
   /**
    *
    *
    * @methodName  userLogFanAll 用户消息中心
    * @author wangdi
    * @param [username]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/16
    */
    @Override
    public QueryResponseResult userLogFanAll(String username) {
        Users users = usersMapper.selectByName(username);

        List<UsersLog> usersLogList = usersLogMapper.fandAllId(users.getId());
        QueryResult<Object> objectQueryResult = new QueryResult<>();
        objectQueryResult.setT(usersLogList);
        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);

    }
}
