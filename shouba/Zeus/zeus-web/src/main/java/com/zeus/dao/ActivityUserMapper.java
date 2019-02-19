package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.ActivityUser;
import com.zeus.entity.CommentsUser;

import java.util.List;

/**
 * @Description
 * @author:wangdi
 * @date:2019/1/15
 * @ver:1.0
 */
public interface ActivityUserMapper extends BaseMapper<ActivityUser> {

    /**
     *
     *
     * @methodName  fanAllActivityProductId  通过活动id查询出该活动参加评论的所有用户
     * @author wangdi
     * @param [activityProductId]
     * @return java.util.List<com.zeus.entity.CommentsUser>
     * @date 2019/1/21
     */
    List<ActivityUser> fanAllActivityProductId(Long activityProductId);

}
