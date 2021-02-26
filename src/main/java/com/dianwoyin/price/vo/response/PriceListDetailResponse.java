package com.dianwoyin.price.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("报价单详情")
public class PriceListDetailResponse implements Serializable {

    @ApiModelProperty("报价单id")
    private Integer priceListId;

    @ApiModelProperty("报价单状态,1:进行中,2:已完成,3:已终止")
    private Integer priceListStatus;

    @ApiModelProperty("商品名")
    private String goodsName;

    @ApiModelProperty("商品图片")
    private String goodsImgUrl;

    @ApiModelProperty("支付金额")
    private BigDecimal payAmount;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("供应商头像集合")
    private List<String> supplierAvatars;

    @ApiModelProperty("产品详情")
    private GoodsDetail goodsDetail;

    @ApiModelProperty("送货详情")
    private DeliveryDetail deliveryDetail;

    @ApiModelProperty("订单详情")
    private OrderDetail orderDetail;

    @ApiModelProperty("报价历史")
    private PriceListReplyDetail priceListReplyDetail;

    @Getter
    @ApiModel("报价单详情-商品详情")
    public static class GoodsDetail {
        @ApiModelProperty("简单属性和属性值")
        private List<SimplePropPair> propValues;

        @ApiModelProperty("备注信息")
        private String comment;
    }

    @Getter
    @ApiModel("报价单详情-报价历史")
    public static class PriceListReplyDetail {
        @ApiModelProperty("供应商名称")
        private String supplierName;

        @ApiModelProperty("供应商头像url")
        private String supplierAvatar;

        @ApiModelProperty("供应商头像url")
        private BigDecimal amount;

        @ApiModelProperty("报价时间")
        private Date createTime;

        @ApiModelProperty("交付时间")
        private Date deliveryTime;

        @ApiModelProperty("备注")
        private String comment;
    }

    @Getter
    @ApiModel("报价单详情-属性/属性值")
    public static class SimplePropPair {

        @ApiModelProperty("属性名")
        private String propName;

        @ApiModelProperty("属性值")
        private String propValue;
    }

    @Getter
    @ApiModel("报价单详情-配送详情")
    public static class DeliveryDetail {

        @ApiModelProperty("期望送达时间")
        private Date expectDeliveryTime;

        @ApiModelProperty("快递渠道, 0：厂家配送，1：快递公司")
        private Integer deliveryChannel;

        @ApiModelProperty("快递公司名称，当deliveryChannel=1时有效")
        private Integer deliveryChannelName;

        @ApiModelProperty("收货人地址")
        private String receiverAddress;

        @ApiModelProperty("收货人详细地址")
        private String receiverAddressDetail;
    }

    @Getter
    @ApiModel("报价单详情-订单详情")
    public static class OrderDetail {

        @ApiModelProperty("订单号码")
        private String orderNo;

        @ApiModelProperty("下单时间")
        private Date orderCreateTime;

        @ApiModelProperty("支付方式, 1: 微信支付")
        private Integer payChannel;
    }

}
