package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.EcsAccountLog;

/**
 * @Description 账户表操作接口
 * @Author wangdi
 * @Date 1/7/2019 23:30
 * @Version V1.0
 */
public interface EcsAccountLogMapper extends BaseMapper<EcsAccountLog>{
    /**
     *
     *
     * @methodName  selectUserEscAccountLog  返回用户的账户
     * @author wangdi
     * @param [id]
     * @return com.zeus.entity.EcsAccountLog
     * @date 2019/1/15
     */
    EcsAccountLog selectUserEscAccountLog(Long userid);
}