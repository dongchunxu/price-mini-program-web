package com.dianwoyin.price.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商户信息表
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Merchant implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
     * 经营类型
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
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
