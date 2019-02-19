package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.ActivityProduct;

import java.util.List;


/**
 * @Description 活动表操作接口
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
public interface ActivityProductMapper extends BaseMapper<ActivityProduct> {

    List<ActivityProduct> asfandAll();

}