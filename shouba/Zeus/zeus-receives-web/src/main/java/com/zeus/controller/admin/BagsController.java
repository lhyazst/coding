package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.entity.Bags;
import com.zeus.exception.CommonCode;
import com.zeus.service.BagsService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Description 回收袋
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/bags/page/")
public class BagsController {
    @Autowired
    private BagsService bagsService;

    /**
     *
     *
     * @methodName bagsFandAll 所有的回收袋管理
     * @author wangdi
     * @param []
     * @return com.zeus.common.Response
     * @date 2019/1/3
     */
    @GetMapping("bagsfandall")
    @ResponseBody
    private QueryResponseResult bagsFandAll() {

        List<Bags> courses = bagsService.bagsFandAll();
        QueryResult<Object> objectQueryResult = new QueryResult<>();
        objectQueryResult.setT(courses);
        return new QueryResponseResult(CommonCode.SUCCESS,objectQueryResult);
    }
    /**
     *
     *
     * @methodName  bagsFandOne 查询出回收站回收袋的详情编号
     * @author wangdi
     * @param [id]
     * @return com.zeus.common.Response
     * @date 2019/1/9
     */
    @GetMapping("bagsfandone/{id}")
    @ResponseBody
    private QueryResponseResult bagsFandOne(@PathVariable("id") Long id){
        if (EmptyUtil.isEmpty(id)) {
            throw new IllegalArgumentException();
        }
     QueryResponseResult response = bagsService.bagsFandOne(id);

        return response;

    }





}
