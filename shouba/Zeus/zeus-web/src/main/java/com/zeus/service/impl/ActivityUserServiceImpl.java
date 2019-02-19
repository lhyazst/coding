package com.zeus.service.impl;


import com.zeus.common.QueryResponseResult;
import com.zeus.dao.ActivityUserMapper;
import com.zeus.dao.UsersMapper;
import com.zeus.entity.ActivityUser;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.ActivityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description 用户参与活动
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
     * @param [username, activityProductid]
     * @return com.zeus.common.QueryResponseResult
     * @methodName addArticleService 用户参加活动
     * @author wangdi
     * @date 2019/1/16
     */
    @Override
    public QueryResponseResult addArticleService(String username, Long activityProductid) {
        Users users = usersMapper.selectByName(username);
        try {
            ActivityUser activityUser = new ActivityUser();
            activityUser.setActivityProductId(activityProductid);
            activityUser.setCreateTime(new Date());
            activityUser.setStatus("0");
            activityUser.setUserId(users.getId());
            activityUserMapper.insert(activityUser);
        } catch (Exception e) {
            e.printStackTrace();
            return new QueryResponseResult(CommonCode.ADD_FAIL, null);
        }
        return new QueryResponseResult(CommonCode.ADD_SUCCESSFUL, null);

    }
}
