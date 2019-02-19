package com.zeus.service;


import com.zeus.common.QueryResponseResult;
import com.zeus.common.Response;

/**
 * @Description  回收箱操作服务层
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface RecycleBinService {


/**
 *
 *
 * @methodName  recycleBinFandAll  查询出回收站点下的所有回收箱
 * @author wangdi
 * @param [recycleSiteId]
 * @return com.zeus.common.QueryResponseResult
 * @date 2019/1/17
 */
  QueryResponseResult recycleBinFandAll(Long recycleSiteId);
}
