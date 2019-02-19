package com.zeus.controller.admin;

import com.github.pagehelper.PageInfo;
import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.common.Response;
import com.zeus.entity.EcsAccountLog;
import com.zeus.entity.Goods;

import com.zeus.exception.CommonCode;
import com.zeus.service.GoodsService;
import com.zeus.service.UsersService;
import com.zeus.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Description 商品
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/goods/page/")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UsersService usersService;

    /**
     * @param []
     * @return com.zeus.common.Response
     * @methodName GoodsFandAll 查询出最新所有商品,并且查询出用户的虚拟币
     * @author wangdi
     * @date 2019/1/3
     */
    @GetMapping("goodsfandall/{type}/{username}")
    @ResponseBody
    private QueryResponseResult goodsFandAll(@PathVariable("type") String type, @PathVariable("username") String username) {


        if (EmptyUtil.isEmpty(type) || EmptyUtil.isEmpty(username)) {
            return new QueryResponseResult(CommonCode.INVALID_PARAM, null);
        }
        List<Goods> goods = goodsService.goodsFandAll(type);
        EcsAccountLog ecsAccountLog = usersService.fanOne(username);
        QueryResult response = new QueryResult();
        response.setList(goods);
        response.setT(ecsAccountLog);

        return new QueryResponseResult(CommonCode.SUCCESS, response);
    }

    /**
     * @param [page, size]
     * @return com.zeus.common.Response
     * @methodName goodsfindpage
     * @author wangdi
     * @date 2019/1/5
     */
    @GetMapping("goodsfindpage/{page}/{size}")
    @ResponseBody
    public Response goodsfindpage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageInfo<Goods> goods = goodsService.goodsfindpage(page, size);

        Response response = new Response();
        response.setData(goods);


        return response;
    }


}
