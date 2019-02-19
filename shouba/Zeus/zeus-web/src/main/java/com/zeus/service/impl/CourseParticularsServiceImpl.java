package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.dao.CourseMapper;
import com.zeus.dao.CourseParticularsMapper;
import com.zeus.entity.Course;
import com.zeus.entity.CourseParticulars;
import com.zeus.exception.CommonCode;
import com.zeus.service.CourseParticularsService;
import com.zeus.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 教程详情操作服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class CourseParticularsServiceImpl implements CourseParticularsService{
  @Autowired
   private CourseParticularsMapper courseParticularsMapper;


    @Override
    public QueryResponseResult courseParticularsFandOne(Long id) {
       List<CourseParticulars> courseParticulars = courseParticularsMapper.fandAllId(id);
        QueryResult queryResult = new QueryResult();
        queryResult.setT(courseParticulars);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
