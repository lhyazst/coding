package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.common.Response;
import com.zeus.dao.AddressMapper;
import com.zeus.dao.BagsMapper;
import com.zeus.dao.UsersMapper;
import com.zeus.entity.Address;
import com.zeus.entity.Bags;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.BagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description  回收袋
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
public class BagsServiceImpl implements BagsService {
  @Autowired
   private BagsMapper bagsMapper;
  @Autowired
  private UsersMapper usersMapper;
  @Autowired
  private AddressMapper addressMapper;

    @Override
    public List<Bags> bagsFandAll() {
        List<Bags> bags = bagsMapper.fandAll();

        return bags;
    }
    /**
     *
     *
     * @methodName  bagsFandOne 返回回收袋的详情信息
     * @author wangdi
     * @param
     * @return com.zeus.common.QueryResponseResult
     * @date 2019/1/19
     */
    @Override
    public QueryResponseResult bagsFandOne(Long id) {

        Bags bags = bagsMapper.selectByPrimaryKey(id);

        Users users = usersMapper.selectByPrimaryKey(bags.getUserId());

        Address address = addressMapper.selectByPrimaryKey(users.getId());
        QueryResult<Object> objectQueryResult = new QueryResult<>();
        Map map = new HashMap(16);
        map.put("bags",bags);
        map.put("users",users);
        map.put("address",address);
      objectQueryResult.setT(map);
        return new QueryResponseResult(CommonCode.SUCCESS,objectQueryResult);
    }
  /**
   *
   *
   * @methodName  bupdateStats 回收员回收成功更改回收袋状态为1
   * @author wangdi
   * @param
   * @return java.lang.Boolean
   * @date 2019/1/16
   */
    @Override
    public Boolean bupdateStats(Long bagsId) {

        try {
            bagsMapper.updateBagsStatus(bagsId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
