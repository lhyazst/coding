package com.zeus.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description 用户POJO类
 * @Author wangdi
 * @Date 17/12/2018 19:39
 * @Version V1.0
 */
@Data
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

}