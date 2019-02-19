package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.dao.BagsMapper;
import com.zeus.dao.RecycleBinMapper;
import com.zeus.dao.WarehouseMapper;
import com.zeus.dao.WorkUsersMapper;
import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.*;
import com.zeus.exception.CommonCode;
import com.zeus.service.ArticleStdmodeService;
import com.zeus.service.RecycleBinService;
import com.zeus.service.WarehouseService;
import com.zeus.service.WorkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 仓库
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;
    @Autowired
     private WorkUsersMapper workUsersMapper;
    @Autowired
    private BagsMapper bagsMapper;
    @Autowired
    private ArticleStdmodeService articleStdmodeService;
    /**
     *
     *
     * @methodName  warehouseUserFanAll  查询该仓库员的所有仓库
     * @author wangdi
     * @param [id]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/18
     */
    @Override
    public QueryResponseResult warehouseUserFanAll(String username) {

        WorkUsers workUsers = workUsersMapper.selectuserName(username);
        List<Warehouse> warehouses = warehouseMapper.selectUserFandAll(workUsers.getId());
        QueryResult<Object> objectQueryResult = new QueryResult<>();

        objectQueryResult.setT(warehouses);

        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
    }
   /**
    *
    *
    * @methodName  warehousebagsFanAll  查出该仓库在那一天的所有回收袋
    * @author wangdi
    * @param [date, id]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/19
    */
    @Override
    public QueryResponseResult warehousebagsFanAll(String date,Long id) {

          List<Bags> list =bagsMapper.warehousebagsFanAll(date,id);

        List<Bags> list2=  bagsMapper.warehousebagsOkFanAll(date,id);
          QueryResult<Object> objectQueryResult = new QueryResult<>();
         Map map = new HashMap<>(16);
         map.put("list",list);
         map.put("list2",list2);
         objectQueryResult.setT(map);
         return new QueryResponseResult(CommonCode.SUCCESS,objectQueryResult);
    }
   /**
    *
    *
    * @methodName  warehousefanOne 跟据id查询出仓库，并返回所有的物品种类
    * @author wangdi
    * @param [id]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/19
    */
    @Override
    public QueryResponseResult warehousefanOne(Long id) {

        Warehouse warehouse = warehouseMapper.selectByPrimaryKey(id);
        List<ArticleStdmode> articleStdmodes = articleStdmodeService.articleStdmodesList();

        Map map = new HashMap(16);

        map.put("warehouse",warehouse);
        map.put("articleStdmodes",articleStdmodes);

        QueryResult<Object> objectQueryResult = new QueryResult<>();
        objectQueryResult.setT(map);
     return new QueryResponseResult(CommonCode.SUCCESS,objectQueryResult);

    }
}
