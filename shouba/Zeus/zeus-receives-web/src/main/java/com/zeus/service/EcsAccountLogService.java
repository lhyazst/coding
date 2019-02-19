package com.zeus.service;

import com.zeus.common.QueryResponseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

/**
 * @Description 用户账户操作
 * @author:wangdi
 * @date:2019/1/15
 * @ver:1.0
 */
public interface EcsAccountLogService {


    void updateUser( Long userid,  Double money);

}
