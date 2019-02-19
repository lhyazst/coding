package com.zeus.entity;

import lombok.Data;



/**
 * @Description 教程详情表实体类
 * @author:wangdi
 * @date:2019/1/3
 * @ver:1.0
 */
@Data
public class CourseParticulars {


    /**
     * 主键ID
     */
    private Long id;

    /**
     * 标题
     */
    private String caption;
    /**
     * 图片
     */
    private String smallPic;
    /**
     * 详情
     */
    private String particulars;

    /**
     * 标记
     */
    private String mark;
    /**
     * 教程id
     */
    private Long courseId;
}
