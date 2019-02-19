package com.zeus.service;


import com.zeus.common.QueryResponseResult;

/**
 * @Description 活动操作服务层
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface SiteWorkUsersService {


    /**
     *
     *
     * @methodName  siteWorkUsersSelect 回收员查询出回收管理里面的统计回收袋数量和站点数量
     * @author wangdi
     * @param []
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/27
     */
    QueryResponseResult siteWorkUsersSelect(String username);


}
