package com.zeus.entity;

import java.util.Date;

/**
 * @Description 回收站点实体类
 * @author:wangdi
 * @date:2019/1/7
 * @ver:1.0
 */
public class RecycleSite {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recycle_site.id
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recycle_site.recycleName
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    private String recyclename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recycle_site.create_time
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recycle_site.update_time
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recycle_site.site_address
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    private String siteAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column recycle_site.status
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recycle_site.id
     *
     * @return the value of recycle_site.id
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recycle_site.id
     *
     * @param id the value for recycle_site.id
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recycle_site.recycleName
     *
     * @return the value of recycle_site.recycleName
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public String getRecyclename() {
        return recyclename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recycle_site.recycleName
     *
     * @param recyclename the value for recycle_site.recycleName
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public void setRecyclename(String recyclename) {
        this.recyclename = recyclename == null ? null : recyclename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recycle_site.create_time
     *
     * @return the value of recycle_site.create_time
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recycle_site.create_time
     *
     * @param createTime the value for recycle_site.create_time
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recycle_site.update_time
     *
     * @return the value of recycle_site.update_time
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recycle_site.update_time
     *
     * @param updateTime the value for recycle_site.update_time
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recycle_site.site_address
     *
     * @return the value of recycle_site.site_address
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public String getSiteAddress() {
        return siteAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recycle_site.site_address
     *
     * @param siteAddress the value for recycle_site.site_address
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress == null ? null : siteAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column recycle_site.status
     *
     * @return the value of recycle_site.status
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column recycle_site.status
     *
     * @param status the value for recycle_site.status
     *
     * @mbggenerated Thu Jan 17 15:19:57 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}
