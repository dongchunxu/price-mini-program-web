package com.dianwoyin.price.vo.response.price;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Getter
@ApiModel("报价单详情-配送详情")
public class DeliveryDetail {

    @ApiModelProperty("期望送达时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
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
