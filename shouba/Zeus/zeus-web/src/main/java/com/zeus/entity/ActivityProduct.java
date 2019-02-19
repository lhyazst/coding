package com.zeus.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description  活动制品
 * @author:wangdi
 * @date:2019/1/4
 * @ver:1.0
 */
@Data
public class ActivityProduct {

    /**
     * 教程 ID
     */
    private Long id;
    /**
     * 标题
     */
    private Long courseId;
    /**
     * 图片
     */
    private String title;
    /**
     * 图片
     */
    private String smallPic;
    /**
     * 原价格
     */
    private Double price;
    /**
     * 活动价格
     */
    private Double costPrice;
    /**
     * 商家ID
     */
    private Long sellerId;
    /**
     * 添加日期
     */
    private Date createTime;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 活动商品数
     */
    private Integer num;
    /**
     * 剩余库存数
     */
    private Integer stockCount;
    /**
     * 描述
     */
    private String introduction;
    /**
     * 审核日期
     */
    private Date checkTime;
    /**
     * 审核状态
     */
    private String status;
    /**
     * 活动详情 ID
     */
    private Long activityProductParticularsId;

    /**
     * 活动地址 ID
     */
    private Long addressId;

    /**
     * 地址
     */
    private Address address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getActivityProductParticularsId() {
        return activityProductParticularsId;
    }

    public void setActivityProductParticularsId(Long activityProductParticularsId) {
        this.activityProductParticularsId = activityProductParticularsId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
