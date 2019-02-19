package com.zeus.service;

import com.github.pagehelper.PageInfo;
import com.zeus.entity.Goods;

import java.util.List;

/**
 * @Description 商品操作服务层
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
public interface GoodsService {


  /**
   * 
   * 
   * @methodName  goodsFandAll 
   * @author wangdi
   * @param [] 
   * @return java.util.List<com.zeus.entity.Goods> 
   * @date 2019/1/10 
   */  
    List<Goods> goodsFandAll(String type);

/**
 * 
 * 
 * @methodName  goodsfindpage 
 * @author wangdi
 * @param [page, size] 
 * @return com.github.pagehelper.PageInfo<com.zeus.entity.Goods> 
 * @date 2019/1/10 
 */  
    PageInfo<Goods> goodsfindpage(Integer page, Integer size);
}
