package com.zeus.entity;

import java.util.Date;

/**
 * @param
 * @author wangdi
 * @methodName 预约站点
 * @return
 * @date 2019/1/10
 */
public class AppointmentRecycleSite {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment_recycle_site.id
     *
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment_recycle_site.recycleName
     *
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    private String recycleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment_recycle_site.create_time
     *
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment_recycle_site.update_time
     *
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment_recycle_site.user_id
     *
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment_recycle_site.status
     *
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column appointment_recycle_site.appointment_time
     *
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    private Date appointmentTime;


    private Address address;
    private Users users;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment_recycle_site.id
     *
     * @return the value of appointment_recycle_site.id
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment_recycle_site.id
     *
     * @param id the value for appointment_recycle_site.id
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getRecycleName() {
        return recycleName;
    }

    public void setRecycleName(String recycleName) {
        this.recycleName = recycleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment_recycle_site.create_time
     *
     * @return the value of appointment_recycle_site.create_time
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment_recycle_site.create_time
     *
     * @param createTime the value for appointment_recycle_site.create_time
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment_recycle_site.update_time
     *
     * @return the value of appointment_recycle_site.update_time
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment_recycle_site.update_time
     *
     * @param updateTime the value for appointment_recycle_site.update_time
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment_recycle_site.status
     *
     * @return the value of appointment_recycle_site.status
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment_recycle_site.status
     *
     * @param status the value for appointment_recycle_site.status
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column appointment_recycle_site.appointment_time
     *
     * @return the value of appointment_recycle_site.appointment_time
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    public Date getAppointmentTime() {
        return appointmentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column appointment_recycle_site.appointment_time
     *
     * @param appointmentTime the value for appointment_recycle_site.appointment_time
     * @mbggenerated Tue Jan 08 14:33:21 CST 2019
     */
    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}