package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.dao.*;
import com.zeus.entity.*;
import com.zeus.exception.CommonCode;
import com.zeus.service.WarehouseArticleLogService;
import com.zeus.service.WarehouseArticleService;
import com.zeus.utils.DateUtils;
import com.zeus.utils.EmptyUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 仓库物品日志操作服务层
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class WarehouseArticleLogServiceImpl implements WarehouseArticleLogService {
    @Autowired
    private WarehouseArticleLogMapper warehouseArticleLogMapper;
    @Autowired
    private WorkUsersMapper workUsersMapper;
    @Autowired
    private WarehouseBagsMapper warehouseBagsMapper;
    @Autowired
    private RecycleUserNumMapper recycleUserNumMapper;
    @Autowired
    private WarehouseArticleMapper warehouseArticleMapper;

    /**
     * @param [warehouseArticleLogs, username]
     * @return com.zeus.common.QueryResponseResult
     * @methodName addWarehouseArticlelog  添加仓库日志
     * @author wangdi
     * @date 2019/1/19
     */
    @Override
    public QueryResponseResult addWarehouseArticlelog(List<WarehouseArticle> warehouseArticles, String username) {
        if (EmptyUtil.isEmpty(warehouseArticles) || EmptyUtil.isEmpty(username)) {
            return new QueryResponseResult(CommonCode.INVALID_PARAM, null);
        }
        WorkUsers workUsers = workUsersMapper.selectuserName(username);
        try {
            for (WarehouseArticle warehouseArticle : warehouseArticles) {
                WarehouseArticleLog warehouseArticleLog = new WarehouseArticleLog();
                warehouseArticleLog.setCreateTime(new Date());
                warehouseArticleLog.setWarehouseId(workUsers.getId());
                warehouseArticleLog.setUpdateTime(new Date());
                warehouseArticleLog.setArticleName(warehouseArticle.getArticleName());
                warehouseArticleLog.setArticleWeight(warehouseArticle.getArticleWeight());
                warehouseArticleLog.setArticlePrice(warehouseArticle.getArticlePrice());
                warehouseArticleLog.setPrice(warehouseArticle.getPrice());
                warehouseArticleLog.setStatus("2");
                warehouseArticleLogMapper.insert(warehouseArticleLog);
            }
        } catch (Exception e) {
            return new QueryResponseResult(CommonCode.ADD_FAIL, null);
        }
        return new QueryResponseResult(CommonCode.SUCCESS, null);
    }

    /**
     * @param [username]
     * @return com.zeus.common.QueryResponseResult
     * @methodName selectWarehouseArticlelog  查询出仓库的所有统计
     * @author wangdi
     * @date 2019/1/19
     */
    @Override
    public QueryResponseResult selectWarehouseArticlelog(String username) {
        if (EmptyUtil.isEmpty(username)) {
            return new QueryResponseResult(CommonCode.INVALID_PARAM, null);
        }
        WorkUsers workUsers = workUsersMapper.selectuserName(username);
        String date = DateUtils.date2String(new Date(), "yyyy-MM-dd");
       //获取该仓管员下的所有回收袋数量要求：当天时间，回收袋状态为2，在同一个仓管员下
        Long userNum = warehouseBagsMapper.selectBagUserNum(workUsers.getId(), date);
        //获取该仓管员下的所有回收袋数量要求：回收袋状态为2
        Long bagsnum = warehouseBagsMapper.selectBagNum();
        //当天回收员数量
        List<RecycleUserNum> recycleUserNums = recycleUserNumMapper.selectRecycleUserNum(workUsers.getId(), date);
         //所有回收员
        List<RecycleUserNum> recycleNums1 = recycleUserNumMapper.selectRecycleNum();
         //当天回收物品种类重量
        List<WarehouseArticleLog> warehouseArticleLogs = warehouseArticleLogMapper.selectWarehouse(workUsers.getId(), date);
        //回收物品种类重量
        List<WarehouseArticleLog> warehouseArticleLogs1 = warehouseArticleLogMapper.selectWarehouseFanAll();
          //回收物品种类
        List<WarehouseArticle> warehouseArticles = warehouseArticleMapper.fandAll();


        double userprice = 0D;
        double userweight = 0L;
        double price = 0D;
        double weight = 0L;
        //计算出物品的总重量和价格
        Map map = new HashMap(16);
        for (WarehouseArticleLog warehouseArticleLog : warehouseArticleLogs) {
            userprice += warehouseArticleLog.getArticleWeight() * warehouseArticleLog.getArticlePrice();
            userweight += warehouseArticleLog.getArticleWeight();
        }
        for (WarehouseArticleLog warehouseArticleLog : warehouseArticleLogs1) {
            price += warehouseArticleLog.getArticleWeight() * warehouseArticleLog.getArticlePrice();
            weight += warehouseArticleLog.getArticleWeight();
        }


        //计算出当天所有物品的重量
        Map map2 = new HashMap(16);
        for (WarehouseArticle warehouseArticle : warehouseArticles) {

            List<WarehouseArticleLog> logList = warehouseArticleLogMapper.selectWarehouseUserName(warehouseArticle.getArticleName(),date);
            if (logList == null || logList.size() < 1) {
                continue;
            }

            double weight3 = 0L;
            for (WarehouseArticleLog warehouseArticleLog : logList) {
                weight3 += warehouseArticleLog.getArticleWeight();

            }
            map2.put(warehouseArticle.getArticleName(), weight3);

        }



        //计算出所有物品的重量
        Map map1 = new HashMap(16);
        for (WarehouseArticle warehouseArticle : warehouseArticles) {

            List<WarehouseArticleLog> logList = warehouseArticleLogMapper.selectWarehouseName(warehouseArticle.getArticleName());
            if (logList == null || logList.size() < 1) {
                continue;
            }

            double weight3 = 0L;
            for (WarehouseArticleLog warehouseArticleLog : logList) {
                weight3 += warehouseArticleLog.getArticleWeight();

            }
            map1.put(warehouseArticle.getArticleName(), weight3);

        }

        map.put("userNum", userNum);
        map.put("bagsnum", bagsnum);
        map.put("recycleUserNums", recycleUserNums);
        map.put("recycleNums1", recycleNums1);
        map.put("weigth", weight);
        map.put("price", price);
        map.put("userprice", userprice);
        map.put("userweight", userweight);
        map.put("num", map1);
        map.put("num1",map2);
        QueryResult<Object> objectQueryResult = new QueryResult<>();
        objectQueryResult.setT(map);
        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);

    }
}
