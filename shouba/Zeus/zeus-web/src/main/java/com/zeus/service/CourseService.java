package com.zeus.service;


import com.zeus.entity.Course;

import java.util.List;

/**
 * @Description 教程操作服务层
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface CourseService {


   /**
    * 
    * 
    * @methodName  courseFandAll 
    * @author wangdi
    * @param [] 
    * @return java.util.List<com.zeus.entity.Course> 
    * @date 2019/1/10 
    */  
    List<Course> courseFandAll();
}
