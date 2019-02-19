package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.common.Response;
import com.zeus.dao.ActivityProductMapper;
import com.zeus.entity.ActivityProduct;
import com.zeus.exception.CommonCode;
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
     * @return java.util.List<com.zeus.entity.ActivityProduct> 查询出所有活动审核为1的互动
     * @methodName activityproductserviceFandAll
     * @author wangdi
     * @date 2019/1/5
     */
    @Override
    public QueryResponseResult activityproductserviceFandAll() {
        List<ActivityProduct> activityProducts = activityProductMapper.asfandAll();

        QueryResult<Object> objectQueryResult = new QueryResult<>();
               objectQueryResult.setT(activityProducts);
        return new QueryResponseResult(CommonCode.SUCCESS,objectQueryResult);
    }
}
