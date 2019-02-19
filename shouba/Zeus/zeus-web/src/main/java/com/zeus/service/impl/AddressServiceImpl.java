package com.zeus.service.impl;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.dao.ActivityProductParticularsMapper;
import com.zeus.dao.AddressMapper;
import com.zeus.dao.CouponMapper;
import com.zeus.dao.UsersMapper;
import com.zeus.entity.ActivityProductParticulars;
import com.zeus.entity.Address;
import com.zeus.entity.Coupon;
import com.zeus.entity.Users;
import com.zeus.exception.CommonCode;
import com.zeus.service.ActivityProductParticularsService;
import com.zeus.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description 地址操作服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service
@Transactional(rollbackFor = { Exception.class })
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private UsersMapper usersMapper;
  /**
   *
   *
   * @methodName  addressAdd  跟用户添加默认地址
   * @author wangdi
   * @param [address, username]
   * @return com.zeus.common.QueryResponseResult
   * @date 2019/1/16
   */
    @Override
    public QueryResponseResult addressAdd(Address address,String username) {
        Users users = usersMapper.selectByName(username);

        try {
                 address.setUserId(users.getId());
            int insert = addressMapper.insert(address);

        } catch (Exception e) {
            e.getMessage();
            return new QueryResponseResult(CommonCode.ADD_FAIL,null);
        }
        return new QueryResponseResult(CommonCode.SUCCESS,null);

    }
   /**
    * 
    * 
    * @methodName  addressFandAll 查询出所有的地址
    * @author wangdi
    * @param [] 
    * @return com.zeus.common.Response 
    * @date 2019/1/21 
    */  
    @Override
    public Response addressFandAll() {

        List<Address> addresses = addressMapper.fandAll();
        Response objectResponse = new Response<>();
        objectResponse.setData(addresses);
        return objectResponse;
    }
}
