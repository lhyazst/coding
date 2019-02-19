package com.zeus.service.impl;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.common.Response;
import com.zeus.dao.*;
import com.zeus.entity.*;
import com.zeus.exception.CommonCode;
import com.zeus.service.ActivityProductParticularsService;
import com.zeus.service.GoodsParticularsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description 商品详情操作服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service

public class GoodsParticularsServiceImpl implements GoodsParticularsService {

    @Autowired
    private GoodsParticularsMapper goodsParticularsMapper;
    @Autowired
    private EcsAccountLogMapper ecsAccountLogMapper;
    @Autowired
    private GoodsAuthorityMapper goodsAuthorityMapper;
    @Autowired
    private UsersMapper usersMapper;

    /**
     *
     *
     * @methodName  goodsParticularsFandOne  用户查询商品详情页
     * @author wangdi
     * @param
     * @return com.zeus.common.Response
     * @date 2019/1/15
     */
    @Override
    public QueryResponseResult goodsParticularsFandOne(Long id,String username) {

        List<GoodsParticulars> goodsParticulars = goodsParticularsMapper.fandAllId(id);
        Users users = usersMapper.selectByName(username);
        EcsAccountLog ecsAccountLog =  ecsAccountLogMapper.selectUserEscAccountLog(users.getId());
        List<GoodsAuthority> goodsAuthority = goodsAuthorityMapper.fandAllId(id);
        Map<String, Object> map = new HashMap<>(16);
        map.put("goodsParticulars", goodsParticulars);
        map.put("ecsAccountLog",ecsAccountLog);
        map.put("goodsAuthority", goodsAuthority);
        QueryResult queryResult = new QueryResult();
        queryResult.setT(map);

        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
