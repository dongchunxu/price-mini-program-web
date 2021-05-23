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
@ApiModel("报价单详情-订单详情")
public class OrderDetail {

    @ApiModelProperty("订单号码")
    private String orderNo;

    @ApiModelProperty("下单时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date orderCreateTime;

    @ApiModelProperty("支付方式, 1: 微信支付")
    private Integer payChannel;
}
