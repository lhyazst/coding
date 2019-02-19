package com.zeus.service;


import com.zeus.common.QueryResponseResult;
import com.zeus.entity.ActivityProduct;

import java.util.List;

/**
 * @Description 用户参与活动
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface ActivityUserService {


    QueryResponseResult addArticleService(String username, Long activityProductid);

}
