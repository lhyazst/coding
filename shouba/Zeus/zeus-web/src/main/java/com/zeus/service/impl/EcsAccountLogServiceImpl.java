package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.constant.Constants;
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

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OrderLogMapper orderLogMapper;
    /**
     *
     *
     * @methodName  acsaccountlogbuy  订单交易
     * @author wangdi
     * @param [acsaccountlogid, goodsId]
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/15
     */
    @Override
    public QueryResponseResult acsaccountlogbuy(Long acsaccountlogid, Long goodsId) {
        try {
            Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
            EcsAccountLog ecsAccountLog = ecsAccountLogMapper.selectByPrimaryKey(acsaccountlogid);
            double userMoney = ecsAccountLog.getUserMoney();
            Double price = goods.getPrice();
            if (userMoney < price) {
                return new QueryResponseResult(CommonCode.INSUFFICIENT_FUND, null);
            }
            String goodsType = goods.getGoodsType();
            if (Constants.ONE_NUM.equals(goodsType)) {
                donate(goods, ecsAccountLog);
            } else if (Constants.TWO_NUM.equals(goodsType)) {
                cash(goods, ecsAccountLog);
            } else if (Constants.THREE_NUM.equals(goodsType)) {
                redEnvelope(goods, ecsAccountLog);
            }
        }catch (Exception e){
            return  new QueryResponseResult(CommonCode.FAIL,null);
        }

        return new QueryResponseResult(CommonCode.SUCCESS, null);
    }
  /**
   *
   *
   * @methodName  redEnvelope  购买红包提现记录日志
   * @author wangdi
   * @param [goods, ecsAccountLog]
   * @return void
   * @date 2019/1/15
   */
    private void redEnvelope(Goods goods, EcsAccountLog ecsAccountLog) {

        synchronized (EcsAccountLogServiceImpl.class) {
            double userMoney = ecsAccountLog.getUserMoney();
            Double price = goods.getPrice();
            double money = userMoney - price;
            ecsAccountLog.setUserMoney(money);
            ecsAccountLog.setChangeType("3");
            ecsAccountLogMapper.updateByPrimaryKey(ecsAccountLog);

        OrderLog orderLog = new OrderLog();
        orderLog.setChangeTime(new Date());
        orderLog.setChangeDesc("红包提现");
        orderLog.setChangeType("3");
        orderLog.setUserMoney(price);
        orderLog.setUserId(ecsAccountLog.getUserId());
        orderLog.setGoodsId(goods.getId());
        orderLogMapper.insert(orderLog);
        }
    }
  /**
   *
   *
   * @methodName  cash 购买商品记录日志
   * @author wangdi
   * @param [goods, ecsAccountLog]
   * @return void
   * @date 2019/1/15
   */
    private void cash(Goods goods, EcsAccountLog ecsAccountLog) {
        synchronized (EcsAccountLogServiceImpl.class) {
            double userMoney = ecsAccountLog.getUserMoney();
            Double price = goods.getPrice();
            double money = userMoney - price;
            ecsAccountLog.setUserMoney(money);
            ecsAccountLog.setChangeType("2");
            ecsAccountLogMapper.updateByPrimaryKey(ecsAccountLog);

        OrderLog orderLog = new OrderLog();
        orderLog.setChangeTime(new Date());
        orderLog.setChangeDesc("兑换");
        orderLog.setChangeType("2");
        orderLog.setUserMoney(price);
        orderLog.setUserId(ecsAccountLog.getUserId());
        orderLog.setGoodsId(goods.getId());
        orderLogMapper.insert(orderLog);
        }
    }
  /**
   *
   *
   * @methodName  donate 捐献记录日志
   * @author wangdi
   * @param [goods, ecsAccountLog]
   * @return void
   * @date 2019/1/15
   */
    private void donate(Goods goods, EcsAccountLog ecsAccountLog) {
        synchronized (EcsAccountLogServiceImpl.class) {
            double userMoney = ecsAccountLog.getUserMoney();
            Double price = goods.getPrice();
            double money = userMoney - price;
            ecsAccountLog.setUserMoney(money);
            ecsAccountLog.setChangeType("1");
            ecsAccountLogMapper.updateByPrimaryKey(ecsAccountLog);

        OrderLog orderLog = new OrderLog();
        orderLog.setChangeTime(new Date());
        orderLog.setChangeDesc("捐赠");
        orderLog.setChangeType("1");
        orderLog.setUserMoney(price);
        orderLog.setUserId(ecsAccountLog.getUserId());
        orderLog.setGoodsId(goods.getId());
        orderLogMapper.insert(orderLog);
        }

    }
}
