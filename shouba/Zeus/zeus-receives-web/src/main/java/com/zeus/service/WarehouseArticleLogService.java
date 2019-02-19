package com.zeus.service;



import com.zeus.common.QueryResponseResult;
import com.zeus.entity.WarehouseArticle;

import java.util.List;


/**
 * @Description 仓库物品种类日志操作服务层
 * @Author wangdi
 * @Date 16/12/2018 21:56
 * @Version V1.0
 */
public interface WarehouseArticleLogService {

  /**
   *
   *
   * @methodName  addWarehouseArticlelog  添加仓库的日志
   * @author wangdi
   * @param [warehouseArticleLogs, username]
   * @return com.zeus.common.QueryResponseResult
   * @date 2019/1/19
   */
    QueryResponseResult addWarehouseArticlelog(List<WarehouseArticle> warehouseArticleLogs, String username);

    QueryResponseResult selectWarehouseArticlelog(String username);

}
