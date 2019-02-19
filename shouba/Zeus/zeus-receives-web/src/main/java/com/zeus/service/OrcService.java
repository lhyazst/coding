package com.zeus.service;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;
import com.zeus.entity.Orc;

/**
 * @Description  扫描二维码
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface OrcService {

   /**
    *
    *
    * @methodName  orcFandOne  扫描二维码返回编号和用户信息
    * @author wangdi
    * @param [orcid]
    * @return com.zeus.common.QueryResponseResult
    * @date 2019/1/17
    */
    QueryResponseResult orcFandOne(Long orcid,String username);

    Boolean updateStatus(Long orcId,Long userid);


    QueryResponseResult workUserOrcFandOne(Long orcid);

}
