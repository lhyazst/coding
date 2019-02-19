package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.entity.Course;
import com.zeus.entity.CourseParticulars;
import com.zeus.service.CourseParticularsService;
import com.zeus.service.CourseService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Description 教程详情
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/courseparticularsfandone/page/")
public class CourseParticularsController {
    @Autowired
    private CourseParticularsService courseParticularsService;

    /**
     * @param [id]
     * @return com.zeus.common.Response
     * @methodName CourseParticularsFandOne
     * @author wangdi
     * @date 2019/1/3
     */
    @GetMapping("courseparticularsfandone/{id}")
    @ResponseBody
    private QueryResponseResult courseParticularsFandOne(@PathVariable("id") Long id) {

        if (EmptyUtil.isEmpty(id)) {
            throw new IllegalArgumentException();
        }

      QueryResponseResult queryResponseResult= courseParticularsService.courseParticularsFandOne(id);


        return queryResponseResult;
    }


}
