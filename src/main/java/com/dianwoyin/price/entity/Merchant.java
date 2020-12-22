package com.dianwoyin.price.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2020/12/12
 */

/**
 * 商户信息表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {
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
    private Integer categoryId;

    /**
     * 商户状态
     */
    private Integer status;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系号码
     */
    private String contactPhone;

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
     * 纬度
     */
    private String latitude;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 是否删除，0：未删除，1：已删除
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
