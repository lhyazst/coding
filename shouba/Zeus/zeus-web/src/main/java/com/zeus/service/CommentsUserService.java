package com.zeus.service;

import com.zeus.common.QueryResponseResult;

/**
 * @Description
 * @author:wangdi
 * @date:2019/1/15
 * @ver:1.0
 */
public interface CommentsUserService {


    QueryResponseResult addComments(String comment, Long activityProductId, String username);
}
