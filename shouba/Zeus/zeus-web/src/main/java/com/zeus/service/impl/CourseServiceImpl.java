package com.zeus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeus.dao.CourseMapper;
import com.zeus.dao.GoodsMapper;
import com.zeus.entity.Course;
import com.zeus.entity.Goods;
import com.zeus.service.CourseService;
import com.zeus.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description  教程操作服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class CourseServiceImpl implements CourseService{
  @Autowired
   private CourseMapper courseMapper;

    @Override
    public List<Course> courseFandAll() {

        List<Course> goods = courseMapper.fandAll();
        return goods;
    }
}
