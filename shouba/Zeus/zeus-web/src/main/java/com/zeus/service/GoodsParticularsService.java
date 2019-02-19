package com.zeus.service;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.entity.GoodsParticulars;

import java.util.List;

/**
 * @Description 商品详情操作服务层
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
public interface GoodsParticularsService {

   /**
    * 
    * 
    * @methodName  goodsParticularsFandOne 查询出对应的商品
    * @author wangdi
    * @param [id] 
    * @return com.zeus.common.Response 
    * @date 2019/1/10 
    */  
    QueryResponseResult goodsParticularsFandOne(Long id,String username);
}
