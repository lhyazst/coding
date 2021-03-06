package com.zeus.entity;

import java.util.Date;

/**
 * @param
 * @author wangdi
 * @methodName 物品实体类
 * @return
 * @date 2019/1/10
 */
public class Article {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.id
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.small_pic
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private String smallPic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.user_id
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.warehouse_id
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private Long warehouseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.recycle_user_id
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private Long recycleUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.create_time
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.status
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.article_name
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private String articleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.article_weight
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private Double articleWeight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.update_time
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article.article_price
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private Double articlePrice;


    private Double price;


    private Long bagsid;

    public Long getBagsid() {
        return bagsid;
    }

    public void setBagsid(Long bagsid) {
        this.bagsid = bagsid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.id
     *
     * @return the value of article.id
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.id
     *
     * @param id the value for article.id
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.small_pic
     *
     * @return the value of article.small_pic
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public String getSmallPic() {
        return smallPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.small_pic
     *
     * @param smallPic the value for article.small_pic
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic == null ? null : smallPic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.user_id
     *
     * @return the value of article.user_id
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.user_id
     *
     * @param userId the value for article.user_id
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.warehouse_id
     *
     * @return the value of article.warehouse_id
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public Long getWarehouseId() {
        return warehouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.warehouse_id
     *
     * @param warehouseId the value for article.warehouse_id
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.recycle_user_id
     *
     * @return the value of article.recycle_user_id
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public Long getRecycleUserId() {
        return recycleUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.recycle_user_id
     *
     * @param recycleUserId the value for article.recycle_user_id
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setRecycleUserId(Long recycleUserId) {
        this.recycleUserId = recycleUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.create_time
     *
     * @return the value of article.create_time
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.create_time
     *
     * @param createTime the value for article.create_time
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.status
     *
     * @return the value of article.status
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.status
     *
     * @param status the value for article.status
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.article_name
     *
     * @return the value of article.article_name
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.article_name
     *
     * @param articleName the value for article.article_name
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.article_weight
     *
     * @return the value of article.article_weight
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public Double getArticleWeight() {
        return articleWeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.article_weight
     *
     * @param articleWeight the value for article.article_weight
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setArticleWeight(Double articleWeight) {
        this.articleWeight = articleWeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.update_time
     *
     * @return the value of article.update_time
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.update_time
     *
     * @param updateTime the value for article.update_time
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.article_price
     *
     * @return the value of article.article_price
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public Double getArticlePrice() {
        return articlePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.article_price
     *
     * @param articlePrice the value for article.article_price
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setArticlePrice(Double articlePrice) {
        this.articlePrice = articlePrice;
    }
}