package com.zeus.service;


import com.zeus.common.QueryResponseResult;
import com.zeus.entity.Course;
import com.zeus.entity.CourseParticulars;

import java.util.List;

/**
 * @Description 教程详情操作服务层
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
public interface CourseParticularsService {



   /**
    * 
    * 
    * @methodName  courseParticularsFandOne 
    * @author wangdi
    * @param [id] 
    * @return com.zeus.entity.CourseParticulars 
    * @date 2019/1/10 
    */  
   QueryResponseResult courseParticularsFandOne(Long id);
}
