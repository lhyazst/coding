package com.zeus.entity;

import java.util.Date;

public class WarehouseBags {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_bags.bags_id
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private Long bagsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_bags.create_time
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_bags.warehouse_id
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    private Long warehouseId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_bags.bags_id
     *
     * @return the value of warehouse_bags.bags_id
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public Long getBagsId() {
        return bagsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_bags.bags_id
     *
     * @param bagsId the value for warehouse_bags.bags_id
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setBagsId(Long bagsId) {
        this.bagsId = bagsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_bags.create_time
     *
     * @return the value of warehouse_bags.create_time
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_bags.create_time
     *
     * @param createTime the value for warehouse_bags.create_time
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_bags.warehouse_id
     *
     * @return the value of warehouse_bags.warehouse_id
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public Long getWarehouseId() {
        return warehouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_bags.warehouse_id
     *
     * @param warehouseId the value for warehouse_bags.warehouse_id
     *
     * @mbggenerated Fri Jan 18 10:39:15 CST 2019
     */
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}