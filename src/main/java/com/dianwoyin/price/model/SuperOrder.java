package com.dianwoyin.price.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SuperOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 交付时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 支付方式, 1: 微信支付
     */
    private Integer payChannel;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品图片
     */
    private String goodsImgUrl;

    /**
     * 商品数量
     */
    private Double goodsQty;

    /**
     * 商品单价
     */
    private Double goodsPrice;

    /**
     * 快递费用
     */
    private Double freightPrice;

    /**
     * 支付总额
     */
    private Double payAmount;

    /**
     * 收货人名称
     */
    private String receiverName;

    /**
     * 收货人电话
     */
    private String receiverPhone;

    /**
     * 收货人地址
     */
    private String receiverAddress;

    /**
     * 收货人详细地址
     */
    private String receiverAddressDetail;

    /**
     * 快递渠道, 0：厂家配送，1：快递公司
     */
    private Integer deliveryChannel;

    /**
     * 快递公司名称，当deliveryChannel=1时有效
     */
    private String deliveryChannelName;

    /**
     * 快递单号, 当deliveryChannel=1时有效
     */
    private String deliveryNo;

    /**
     * 快递员手机, 当deliveryChannel=0时有效
     */
    private String deliveryPhone;

    /**
     * 快递员姓名, 当deliveryChannel=0时有效
     */
    private String deliveryPerson;

    /**
     * 创建人id
     */
    private Integer createdId;

    /**
     * 订单状态, 1:待支付,2:待发货,3:待收货,4:已退款,5:已完成
     */
    private Integer status;

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
