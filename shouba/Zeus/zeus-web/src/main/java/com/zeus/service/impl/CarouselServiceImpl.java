package com.zeus.service.impl;

import com.zeus.common.QueryResponseResult;
import com.zeus.common.QueryResult;
import com.zeus.dao.CarouselMapper;
import com.zeus.entity.Carousel;
import com.zeus.exception.CommonCode;
import com.zeus.service.CarouselService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.management.Query;
import java.util.List;

/**
 * @Description 商品操作服务实现类
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
@Service

public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;
 /**
  *
  *
  * @methodName  fandAll 查询出轮播图
  * @author wangdi
  * @param []
  * @return com.zeus.common.QueryResponseResult
  * @date 2019/1/21
  */
    @Override
    public QueryResponseResult fandAll() {

        List<Carousel> carousels = carouselMapper.fandAll();

        QueryResult queryResult = new QueryResult();
        queryResult.setT(carousels);

        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
