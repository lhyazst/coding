package com.zeus.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description 用户POJO类
 * @Author 元稹
 * @Date 17/12/2018 19:39
 * @Version V1.0
 */
@Data
public class User {

    /**
     * 主键ID
     */
    private Integer id;

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
    private Integer gender;

    /**
     * 用户出生日期
     */
    private Date birthday;

    /**
     * 用户邮箱
     */
    private String email;

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

}