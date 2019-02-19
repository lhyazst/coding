package com.zeus.service;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.entity.ActivityProduct;
import com.zeus.entity.Address;

import java.util.List;

/**
 * @Description 地址操作服务层
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface AddressService {

/**
 *
 *
 * @methodName  addressAdd//用户添加地址
 * @author wangdi
 * @param [address]
 * @return java.lang.Boolean
 * @date 2019/1/10
 */
 QueryResponseResult addressAdd(Address address,String username);
/**
 *
 *
 * @methodName  addressFandAll
 * @author wangdi
 * @param []
 * @return com.zeus.common.Response
 * @date 2019/1/10
 */
    Response addressFandAll();
}
