package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.common.Response;

import com.zeus.entity.Course;
import com.zeus.exception.CommonCode;
import com.zeus.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Description 教程
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/course/page/")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     *
     *
     * @methodName GoodsFandAll 查询出所有的教程
     * @author wangdi
     * @param []
     * @return com.zeus.common.Response
     * @date 2019/1/3
     */
    @GetMapping("coursefandall")
    @ResponseBody
    private QueryResponseResult goodsFandAll() {

        List<Course> courses = courseService.courseFandAll();
        QueryResult queryResult = new QueryResult();
        queryResult.setT(courses);

        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }


}
