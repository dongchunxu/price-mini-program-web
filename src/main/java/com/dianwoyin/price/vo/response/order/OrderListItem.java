package com.dianwoyin.price.vo.response.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Getter
@ApiModel("订单列表item")
public class OrderListItem implements Serializable {

    @ApiModelProperty("订单id")
    private Integer orderId;

    @ApiModelProperty("订单状态, 1:待支付,2:待发货,3:待收货,4:已退款,5:已完成")
    private Integer orderStatus;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    @ApiModelProperty("生产厂家")
    private String supplierName;

    @ApiModelProperty("生产厂家电话")
    private String supplierPhone;

    @ApiModelProperty("支付金额")
    private BigDecimal payAmount;
}
