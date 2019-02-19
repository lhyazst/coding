package com.zeus.service;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.entity.ActivityProductParticulars;
import com.zeus.entity.CourseParticulars;

/**
 * @Description 活动详情操作服务层
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
public interface ActivityProductParticularsService {
/**
 * 
 * 
 * @methodName  activityProductParticularsServicefandOne 
 * @author wangdi
 * @param [id] 
 * @return com.zeus.common.Response 
 * @date 2019/1/10 
 */  
  QueryResponseResult activityProductParticularsServicefandOne(  Long activityProductId);
}
