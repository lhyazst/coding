package com.zeus.entity;

import lombok.Data;

/**
 * @Description 商品认证机构
 * @author:wangdi
 * @date:2019/1/5
 * @ver:1.0
 */
@Data
public class GoodsAuthority {

    /**
     * ID
     */
    private Long id;
    /**
     * 状态
     */
    private String auditStatus;
    /**
     * 标题
     */
    private String organization;
    /**
     * 商品id
     */
    private Long goodsId;
}
