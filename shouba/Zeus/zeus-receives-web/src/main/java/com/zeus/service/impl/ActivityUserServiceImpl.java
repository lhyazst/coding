package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.common.Response;
import com.zeus.dao.ActivityUserMapper;
import com.zeus.dao.UsersMapper;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.ActivityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 参与活动用户操作服务层
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class ActivityUserServiceImpl implements ActivityUserService {
    @Autowired
    private ActivityUserMapper activityUserMapper;

    @Autowired
    private UsersMapper usersMapper;

    /**
     *
     *
     * @methodName  activityUserserviceFandOne  查询出参与此活动的所有用户
     * @author wangdi
     * @param [id]
     * @return com.zeus.common.Response
     * @date 2019/1/17
     */
    @Override
    public QueryResponseResult activityUserserviceFandOne(Long id) {

        List<Users> list = usersMapper.usfandAll(id);

        QueryResult<Object> objectQueryResult = new QueryResult<>();
        objectQueryResult.setT(list);
        return new QueryResponseResult(CommonCode.SUCCESS,objectQueryResult);
    }
}
