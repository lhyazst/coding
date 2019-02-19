package com.zeus.service.impl;

import com.zeus.dao.ActivityProductMapper;

import com.zeus.entity.ActivityProduct;

import com.zeus.service.ActivityProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description  活动操作服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class ActivityProductServiceImpl implements ActivityProductService {
    @Autowired
    private ActivityProductMapper activityProductMapper;

    /**
     * @param []
     * @return java.util.List<com.zeus.entity.ActivityProduct>  //查询出所有状态为1的活动
     * @methodName activityproductserviceFandAll
     * @author wangdi
     * @date 2019/1/5
     */
    @Override
    public List<ActivityProduct> activityproductserviceFandAll() {
        List<ActivityProduct> activityProducts = activityProductMapper.fandAll();

        return activityProducts;
    }
}
