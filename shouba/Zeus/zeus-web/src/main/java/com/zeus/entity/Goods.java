package com.zeus.entity;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description 商品
 * @author:wangdi
 * @date:2019/1/3
 * @ver:1.0
 */
@Data
public class Goods {

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
    private String smallpic;
    /**
     * 详情
     */
    private String particulars;
    /**
     * goods详情ID
     */
    private Long goodsParticulars;
    /**
     * 商品价
     */
    private Double price;
    /**
     * 是否上架
     */
    private String isMarketable;
    /**
     * 是否删除
     */
    private String isDelete;
    /**
     * 商家ID
     */
    private String sellerId;
    /**
     * 商品类型
     */
    private String goodsType;
    /**
     * 创建时间
     */
   private Date createTime;
    /**
     * 更新时间
     */
   private Date updateTime;

}
