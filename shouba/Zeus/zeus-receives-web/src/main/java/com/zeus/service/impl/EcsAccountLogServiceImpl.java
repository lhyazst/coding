package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.dao.EcsAccountLogMapper;
import com.zeus.dao.GoodsMapper;
import com.zeus.dao.OrderLogMapper;
import com.zeus.entity.EcsAccountLog;
import com.zeus.entity.Goods;
import com.zeus.entity.OrderLog;
import com.zeus.exception.CommonCode;
import com.zeus.service.EcsAccountLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Description  购买商品
 * @author:wangdi
 * @date:2019/1/15
 * @ver:1.0
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class EcsAccountLogServiceImpl implements EcsAccountLogService {
    @Autowired
    private EcsAccountLogMapper ecsAccountLogMapper;


    @Override
    public void updateUser(Long userid, Double money) {
        EcsAccountLog ecsAccountLog = ecsAccountLogMapper.selectByPrimaryKey(userid);
        ecsAccountLog.setUserMoney(ecsAccountLog.getUserMoney()+money);
        ecsAccountLogMapper.updateByPrimaryKey(ecsAccountLog);

    }
}
