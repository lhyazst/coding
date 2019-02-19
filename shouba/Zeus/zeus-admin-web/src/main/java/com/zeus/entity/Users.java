package com.zeus.entity;

import com.zeus.utils.DateUtils;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description 用户POJO类
 * @Author wangdi
 * @Date 17/12/2018 19:39
 * @Version V1.0
 */
public class Users {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 花名
     */
    private String nickName;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 用户角色
     */
    private Integer role;

    /**
     * 用户性别
     */
    private String gender;

    /**
     * 用户出生日期
     */
    private Date birthday;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     *地址表
     */
    private Address address;
    /**
     *物品
     */
    private List<Article> articles;

    /**
     *生日
     */
    private String birthdays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
        String date = DateUtils.date2String(birthday, "yyyy-MM-dd");
        setBirthdays(date);

    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getBirthdays() {
        return birthdays;
    }

    public void setBirthdays(String birthdays) {
        this.birthdays = birthdays;
    }
}