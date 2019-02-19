package com.zeus.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description 地址实体类
 * @author:wangdi
 * @date:2019/1/5
 * @ver:1.0
 */
@Data
public class Address {
    /**
     * 地址id
     */
    private Long sid;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 省
     */
    private String provinceId;
    /**
     * 市
     */
    private String cityId;
    /**
     * 县/区
     */
    private String townId;
    /**
     * 街道
     */
    private String street;
    /**
     * 小区
     */
    private String community;
    /**
     * 其它小区
     */
    private String otherCommunity;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 是否是默认 1默认 0否
     */
    private String isDefault;
    /**
     * 创建日期
     */
    private Date createDate;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getTownId() {
        return townId;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getOtherCommunity() {
        return otherCommunity;
    }

    public void setOtherCommunity(String otherCommunity) {
        this.otherCommunity = otherCommunity;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
