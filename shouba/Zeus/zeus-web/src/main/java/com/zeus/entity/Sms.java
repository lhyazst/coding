package com.zeus.entity;

import java.util.Date;
/**
 * @Description
 * @Author wangdi
 * @Date 1/3/2019 23:30
 * @Version V1.0
 */
public class Sms {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms.id
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms.sms_number
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    private Long smsNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms.create_time
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms.end_time
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms.phone
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    private Long phone;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms.id
     *
     * @return the value of sms.id
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms.id
     *
     * @param id the value for sms.id
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms.sms_number
     *
     * @return the value of sms.sms_number
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    public Long getSmsNumber() {
        return smsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms.sms_number
     *
     * @param smsNumber the value for sms.sms_number
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    public void setSmsNumber(Long smsNumber) {
        this.smsNumber = smsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms.create_time
     *
     * @return the value of sms.create_time
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms.create_time
     *
     * @param createTime the value for sms.create_time
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms.end_time
     *
     * @return the value of sms.end_time
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms.end_time
     *
     * @param endTime the value for sms.end_time
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms.phone
     *
     * @return the value of sms.phone
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms.phone
     *
     * @param phone the value for sms.phone
     *
     * @mbggenerated Tue Jan 15 16:09:15 CST 2019
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }
}