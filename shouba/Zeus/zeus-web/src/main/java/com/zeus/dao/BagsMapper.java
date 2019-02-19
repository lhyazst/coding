package com.zeus.dao;

import com.zeus.dao.base.BaseMapper;
import com.zeus.entity.Bags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 回收袋操作接口
 * @Author wangdi
 * @Date 1/7/2019 23:30
 * @Version V1.0
 */
public interface BagsMapper extends BaseMapper<Bags>{

    Bags selecttow(@Param("userId") Long userId, @Param("orcNumber") Long orcNumber);

    Long fandAllNum(Long id);

   Long fanduserId(Long id);


}