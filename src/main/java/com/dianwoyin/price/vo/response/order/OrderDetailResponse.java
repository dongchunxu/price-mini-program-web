package com.dianwoyin.price.vo.response.order;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date deliveryTime;

    @ApiModelProperty("支付时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
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

}
