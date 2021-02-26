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
@ApiModel("订单列表")
public class OrderListResponse implements Serializable {

    @ApiModelProperty("订单子项")
    private List<OrderListItem> orderListItems;

    @Getter
    @ApiModel("订单列表item")
    public static class OrderListItem implements Serializable {

        @ApiModelProperty("订单id")
        private Integer orderId;

        @ApiModelProperty("订单状态, 1:待支付,2:待发货,3:待收货,4:已退款,5:已完成")
        private Integer orderStatus;

        @ApiModelProperty("创建时间")
        private Date createTime;

        @ApiModelProperty("生产厂家")
        private String supplierName;

        @ApiModelProperty("生产厂家电话")
        private String supplierPhone;

        @ApiModelProperty("支付金额")
        private BigDecimal payAmount;
    }
}
