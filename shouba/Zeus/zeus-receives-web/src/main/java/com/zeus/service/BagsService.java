package com.zeus.service;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.entity.Bags;
import com.zeus.entity.Course;

import java.util.List;

/**
 * @Description 回收袋操作服务层
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface BagsService {


    List<Bags> bagsFandAll();


    QueryResponseResult bagsFandOne(Long id);
  /**
   *
   *
   * @methodName  bupdateStats 回收员回收回收袋改变回收袋的状态
   * @author wangdi
   * @param [bagsId, userId]
   * @return java.lang.Boolean
   * @date 2019/1/27
   */
    Boolean bupdateStats(Long bagsId);
}
