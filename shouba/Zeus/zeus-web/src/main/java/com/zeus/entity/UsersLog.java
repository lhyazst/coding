package com.zeus.entity;

import java.util.Date;
/**
 * @Description
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
public class UsersLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_log.id
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_log.user_id
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_log.money
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    private Double money;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_log.warehouse_id
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    private Long warehouseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_log.create_time
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_log.particulars
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    private String particulars;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_log.id
     *
     * @return the value of users_log.id
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_log.id
     *
     * @param id the value for users_log.id
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_log.user_id
     *
     * @return the value of users_log.user_id
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_log.user_id
     *
     * @param userId the value for users_log.user_id
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_log.money
     *
     * @return the value of users_log.money
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public Double getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_log.money
     *
     * @param money the value for users_log.money
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_log.warehouse_id
     *
     * @return the value of users_log.warehouse_id
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public Long getWarehouseId() {
        return warehouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_log.warehouse_id
     *
     * @param warehouseId the value for users_log.warehouse_id
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_log.create_time
     *
     * @return the value of users_log.create_time
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_log.create_time
     *
     * @param createTime the value for users_log.create_time
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_log.particulars
     *
     * @return the value of users_log.particulars
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public String getParticulars() {
        return particulars;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_log.particulars
     *
     * @param particulars the value for users_log.particulars
     *
     * @mbggenerated Wed Jan 16 14:47:00 CST 2019
     */
    public void setParticulars(String particulars) {
        this.particulars = particulars == null ? null : particulars.trim();
    }
}