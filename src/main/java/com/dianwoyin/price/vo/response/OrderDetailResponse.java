package com.dianwoyin.price.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("订单详情")
public class OrderDetailResponse implements Serializable {

    @ApiModelProperty("订单id")
    private Integer orderId;

    @ApiModelProperty("订单no")
    private Integer orderNo;

    @ApiModelProperty("订单状态, 1:待支付,2:待发货,3:待收货,4:已退款,5:已完成")
    private Integer orderStatus;

    @ApiModelProperty("交付时间")
    private Date deliveryTime;

    @ApiModelProperty("支付时间")
    private Date payTime;

    @ApiModelProperty("支付方式, 1: 微信支付")
    private Integer payChannel;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品图片")
    private String goodsImgUrl;

    @ApiModelProperty("商品数量")
    private Integer goodsQty;

    @ApiModelProperty("商品单价")
    private BigDecimal goodsPrice;

    @ApiModelProperty("快递费用")
    private BigDecimal freightPrice;

    @ApiModelProperty("支付总额")
    private BigDecimal payAmount;

    @ApiModelProperty("配送信息")
    private DeliveryDetail deliveryDetail;

    @Getter
    @ApiModel("报价单详情-配送详情")
    public static class DeliveryDetail {
        @ApiModelProperty("收货人名称")
        private String receiverName;

        @ApiModelProperty("收货人电话")
        private String receiverPhone;

        @ApiModelProperty("快递渠道, 0：厂家配送，1：快递公司")
        private Integer deliveryChannel;

        @ApiModelProperty("快递公司名称，当deliveryChannel=1时有效")
        private Integer deliveryChannelName;

        @ApiModelProperty("快递单号, 当deliveryChannel=1时有效")
        private String deliveryNo;

        @ApiModelProperty("快递员手机, 当deliveryChannel=0时有效")
        private String deliveryPhone;

        @ApiModelProperty("快递员姓名, 当deliveryChannel=0时有效")
        private String deliveryPerson;

        @ApiModelProperty("收货人地址")
        private String receiverAddress;

        @ApiModelProperty("收货人详细地址")
        private String receiverAddressDetail;
    }
}
