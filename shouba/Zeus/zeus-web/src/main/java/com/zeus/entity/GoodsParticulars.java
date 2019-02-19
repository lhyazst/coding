package com.zeus.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description 商品详情实体类
 * @author:wangdi
 * @date:2019/1/5
 * @ver:1.0
 */
@Data
public class GoodsParticulars {

    /**
     * 商品详情ID
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 商品详情
     */
    private String particulars;
    /**
     * 图片
     */
    private String smallPic;
    /**
     * 商家ID
     */
    private String sellerId;
    /**
     * 添加日期
     */
    private Date createTime;

    /**
     * 商品ID
     */
    private Long goodsId;


}
