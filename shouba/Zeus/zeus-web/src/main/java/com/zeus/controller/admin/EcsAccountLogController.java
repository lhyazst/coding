package com.zeus.controller.admin;


import com.zeus.common.QueryResponseResult;
import com.zeus.service.EcsAccountLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * @Description 用户账户操作
 * @Author wangdi
 * @Date 1/8/2019 23:30
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/acsaccountlog/customer/")
public class EcsAccountLogController {
      @Autowired
      private EcsAccountLogService ecsAccountLogService;
      /**
       *
       *
       * @methodName  acsaccountlogBuy 提交商品订单
       * @author wangdi
       * @param [acsaccountlogid, goodsId]
       * @return com.zeus.common.QueryResponseResult
       * @date 2019/1/21
       */
     @GetMapping("acsaccountlogbuy/{acsaccountlogid}/{goodsId}")
     @ResponseBody
    public QueryResponseResult acsaccountlogBuy(@PathVariable("acsaccountlogid")Long acsaccountlogid,@PathVariable("goodsId") Long goodsId){


          QueryResponseResult queryResponseResult = ecsAccountLogService.acsaccountlogbuy(acsaccountlogid,goodsId);

     return  queryResponseResult;

    }




}
