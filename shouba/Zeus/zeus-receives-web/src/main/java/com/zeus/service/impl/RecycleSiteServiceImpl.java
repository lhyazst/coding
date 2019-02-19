package com.zeus.service.impl;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.common.Response;
import com.zeus.dao.RecycleSiteMapper;
import com.zeus.entity.RecycleSite;
import com.zeus.exception.CommonCode;
import com.zeus.service.RecycleSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 回收站点服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class RecycleSiteServiceImpl implements RecycleSiteService {



    @Autowired
    private RecycleSiteMapper recycleSiteMapper;

/**
 *
 *
 * @methodName  RecycleStieFandAll 查询出所有状态等于0的站点
 * @author wangdi
 * @param []
 * @return com.zeus.common.Response
 * @date 2019/1/10
 */
    @Override
    public QueryResponseResult recycleStieFandAll() {

        List<RecycleSite> recycleSites = recycleSiteMapper.fandAll();
        QueryResult<Object> objectQueryResult = new QueryResult<>();
        objectQueryResult.setT(recycleSites);
        return new QueryResponseResult(CommonCode.SUCCESS,objectQueryResult);
    }
}
