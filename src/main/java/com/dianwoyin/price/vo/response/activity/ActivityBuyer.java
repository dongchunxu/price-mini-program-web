package com.dianwoyin.price.vo.response.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@ApiModel("活动-买家")
@Data
@Builder
public class ActivityBuyer {
    @ApiModelProperty("买家名称")
    private String buyerName;

    @ApiModelProperty("买家头像")
    private String buyerAvatar;

    @ApiModelProperty("报价时间")
    private String buyTime;
}
