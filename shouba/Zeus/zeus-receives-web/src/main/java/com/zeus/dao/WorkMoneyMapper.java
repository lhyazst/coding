package com.zeus.dao;


import java.util.List;

import com.zeus.entity.WorkMoney;
import org.apache.ibatis.annotations.Param;

public interface WorkMoneyMapper {
  /**
   *
   *
   * @methodName  selectFandOne  返回虚拟币的类型
   * @author wangdi
   * @param [s]
   * @return com.zeus.entity.WorkMoney
   * @date 2019/1/19
   */
    WorkMoney selectFandOne(String s);
}