package com.dianwoyin.price.vo.response.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Getter
@ApiModel("报价单详情-配送详情")
public class DeliveryDetail {
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
