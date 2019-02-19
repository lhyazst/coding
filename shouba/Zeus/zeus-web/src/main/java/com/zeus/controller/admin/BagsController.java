package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.entity.Bags;
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




}
