package com.zeus.entity;

import java.util.Date;

/**
 * @Description 二维码
 * @Author wangdi
 * @Date 1/8/2019 23:30
 * @Version V1.0
 */
public class Orc {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orc.id
     *
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orc.orc_number
     *
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    private Long orcNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orc.create_time
     *
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orc.update_time
     *
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orc.user_id
     *
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orc.status
     *
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orc.recycle_user_id
     *
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    private Long recycleUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orc.orc_url
     *
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    private String orcUrl;

    /**
     * 站点名称
     */
    private String siteName;


    /**
     * 站点id
     */
    private Long siteId;


    /**
     * 二维码类型
     */
    private String orcType;

    public String getOrcType() {
        return orcType;
    }

    public void setOrcType(String orcType) {
        this.orcType = orcType;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orc.id
     *
     * @return the value of orc.id
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orc.id
     *
     * @param id the value for orc.id
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orc.orc_number
     *
     * @return the value of orc.orc_number
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public Long getOrcNumber() {
        return orcNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orc.orc_number
     *
     * @param orcNumber the value for orc.orc_number
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public void setOrcNumber(Long orcNumber) {
        this.orcNumber = orcNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orc.create_time
     *
     * @return the value of orc.create_time
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orc.create_time
     *
     * @param createTime the value for orc.create_time
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orc.update_time
     *
     * @return the value of orc.update_time
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orc.update_time
     *
     * @param updateTime the value for orc.update_time
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orc.user_id
     *
     * @return the value of orc.user_id
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orc.user_id
     *
     * @param userId the value for orc.user_id
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orc.status
     *
     * @return the value of orc.status
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orc.status
     *
     * @param status the value for orc.status
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orc.recycle_user_id
     *
     * @return the value of orc.recycle_user_id
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public Long getRecycleUserId() {
        return recycleUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orc.recycle_user_id
     *
     * @param recycleUserId the value for orc.recycle_user_id
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public void setRecycleUserId(Long recycleUserId) {
        this.recycleUserId = recycleUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orc.orc_url
     *
     * @return the value of orc.orc_url
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public String getOrcUrl() {
        return orcUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orc.orc_url
     *
     * @param orcUrl the value for orc.orc_url
     * @mbggenerated Tue Jan 08 15:50:02 CST 2019
     */
    public void setOrcUrl(String orcUrl) {
        this.orcUrl = orcUrl == null ? null : orcUrl.trim();
    }
}