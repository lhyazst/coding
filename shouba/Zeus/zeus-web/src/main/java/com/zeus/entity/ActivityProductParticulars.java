package com.zeus.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description 活动详情
 * @author:wangdi
 * @date:2019/1/4
 * @ver:1.0
 */
@Data
public class ActivityProductParticulars {
    /**
     * 活动详情id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
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
     * 规则
     */
    private String introduction;
    /**
     * 优惠卷ID
     */
    private String couponId;
    /**
     * 活动详情
     */
    private Long activityProductId;

}
