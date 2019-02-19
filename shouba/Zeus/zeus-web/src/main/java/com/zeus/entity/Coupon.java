package com.zeus.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description 优惠卷
 * @author:wangdi
 * @date:2019/1/4
 * @ver:1.0
 */
@Data
public class Coupon {

    /**
     * 优惠卷id
     */
    private Long id;
    /**
     * 满足金额
     */
    private Double price;
    /**
     * 优惠金额
     */
    private Double conponPrice;
    /**
     * 优惠卷类型
     */
    private String couponType;
    /**
     * 开始时间
     */
    private Date begintime;
    /**
     * 结束时间
     */
    private Date endtime;
    /**
     * 状态
     */
    private String status;
}
