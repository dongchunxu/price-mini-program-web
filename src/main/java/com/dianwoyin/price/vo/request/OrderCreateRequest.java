package com.dianwoyin.price.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@ApiModel("订单创建对象")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateRequest {

    @ApiModelProperty("渠道，1: 活动，2：报价")
    @NotNull(message = "渠道必填")
    private Integer channel;

    @ApiModelProperty("id, channel = 1，为activityId; channel = 2, 为priceListId")
    @NotNull(message = "referId必填")
    private Integer referId;

    @ApiModelProperty("联系人姓名")
    @NotNull(message = "联系人姓名必填")
    private String receiverName;

    @ApiModelProperty("联系号码")
    @NotNull(message = "联系号码必填")
    private String receiverPhone;

    @ApiModelProperty("商品数量")
    @NotNull(message = "商品数量必填")
    private Integer goodsQty;

    @ApiModelProperty("商品单价")
    @NotNull(message = "商品单价必填")
    private BigDecimal goodsPrice;

    @ApiModelProperty("运费")
    @NotNull(message = "运费必填")
    private BigDecimal freightPrice;

    @ApiModelProperty("总价")
    @NotNull(message = "总价必填")
    private BigDecimal amount;

    @ApiModelProperty("省份")
    @NotNull(message = "省份必填")
    private String province;

    @ApiModelProperty("城市")
    @NotNull(message = "城市必填")
    private String city;

    @ApiModelProperty("区")
    @NotNull(message = "区必填")
    private String district;

    @ApiModelProperty("街道")
    private String street;

    @ApiModelProperty("详细地址")
    @NotNull(message = "详细地址必填")
    private String addressDetail;


}
