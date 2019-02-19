package com.zeus.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description 教程表实体类
 * @author:wangdi
 * @date:2019/1/3
 * @ver:1.0
 */
@Data
public class Course {


    /**
     * 主键ID
     */
    private Long id;
    /**
     * 状态
     */
    private String auditStatus;
    /**
     * 标题
     */
    private String caption;
    /**
     * 小图
     */
    private String smallPic;
    /**
     * 详情
     */
    private String particulars;
    /**
     * 教程Id
     */
    private String goodsParticularsId;
    /**
     * 创建时间
     */
    private Date createTime;
}
