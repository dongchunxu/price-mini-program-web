package com.dianwoyin.price.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2021/6/3
 */
@Data
public class MerchantDTO {
    private Integer id;

    /**
     * 商户名
     */
    private String merchantName;

    /**
     * 图片url
     */
    private String imgUrl;

    /**
     * 类目id
     */
    private String businessType;

    /**
     * 商户状态
     */
    private Integer status;

    /**
     * 联系人姓名
     */
    private String receiverName;

    /**
     * 联系号码
     */
    private String receiverPhone;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 街道
     */
    private String street;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 规范化地址
     */
    private String formattedAddress;

    /**
     * 创建时间
     */
    private Date createTime;
}
