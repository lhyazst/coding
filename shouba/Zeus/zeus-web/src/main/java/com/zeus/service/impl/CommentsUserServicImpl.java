package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.dao.CommentsUserMapper;
import com.zeus.dao.UsersMapper;
import com.zeus.entity.CommentsUser;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.CommentsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description  参与评论的的用户
 * @author:wangdi
 * @date:2019/1/15
 * @ver:1.0
 */
@Service
public class CommentsUserServicImpl implements CommentsUserService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private CommentsUserMapper commentsUserMapper;

    /**
     * @param [comment, activityProductId, username]
     * @return com.zeus.common.QueryResponseResult
     * @methodName addComments  用户添加评论
     * @author wangdi
     * @date 2019/1/15
     */
    @Override
    public QueryResponseResult addComments(String comment, Long activityProductId, String username) {

        Users users = usersMapper.selectByName(username);

        try {
            CommentsUser commentsUser = new CommentsUser();
            commentsUser.setUserId(users.getId());
            commentsUser.setCreateTime(new Date());
            commentsUser.setActivityProductId(activityProductId);
            commentsUser.setComments(comment);
            commentsUser.setStatus("1");
            commentsUserMapper.insert(commentsUser);
        } catch (Exception e) {
            e.printStackTrace();
            return new QueryResponseResult(CommonCode.ADD_FAIL, null);
        }
        return new QueryResponseResult(CommonCode.ADD_SUCCESSFUL, null);
    }
}
