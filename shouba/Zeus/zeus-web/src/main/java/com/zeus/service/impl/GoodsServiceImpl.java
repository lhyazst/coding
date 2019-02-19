package com.zeus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zeus.constant.Constants;
import com.zeus.dao.GoodsMapper;
import com.zeus.entity.Goods;
import com.zeus.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Description 商品操作服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service

public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

  /**
   *
   *
   * @methodName  goodsFandAll
   * @author wangdi
   * @param [type]
   * @return java.util.List<com.zeus.entity.Goods>
   * @date 2019/1/22
   */
    @Override
    public List<Goods> goodsFandAll(String type) {

        if(Constants.ONE_NUM.equals(type)){
                return goodsMapper.fandAllDonate(type);
            }else {
                return goodsMapper.fandAllConvert (type);
            }

    }

    @Override
    public PageInfo<Goods> goodsfindpage(Integer page, Integer size) {

        //分页参数
        if(page <=0){
            page = 1;
        }
        page = page -1;
        if(size<=0){
            size = 10;
        }
        PageHelper.startPage(page, size);
        List<Goods> docs =goodsMapper.fandAll();
        PageInfo<Goods> pageInfo = new PageInfo<>(docs);

        return pageInfo;
    }


}
