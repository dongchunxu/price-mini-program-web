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
}
