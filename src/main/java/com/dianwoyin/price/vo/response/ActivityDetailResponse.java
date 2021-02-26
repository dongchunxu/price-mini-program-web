package com.dianwoyin.price.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("活动详情")
public class ActivityDetailResponse {

    @ApiModelProperty("活动图片")
    private String activityImgUrl;

    @ApiModelProperty("活动名称")
    private String activityName;

    @ApiModelProperty("现价")
    private BigDecimal amount;

    @ApiModelProperty("原价")
    private BigDecimal originAmount;

    @ApiModelProperty("已售数量")
    private Integer saleQty;

    @ApiModelProperty("标签信息")
    private List<String> tags;

    @ApiModelProperty("买家信息")
    private List<ActivityBuyer> buyersInfo;

    @ApiModelProperty("详情图片")
    private List<String> descriptionUrls;


    @Getter
    @ApiModel("活动-买家")
    public static class ActivityBuyer {
        @ApiModelProperty("买家名称")
        private String buyerName;

        @ApiModelProperty("买家头像")
        private String buyerAvatar;

        @ApiModelProperty("报价时间")
        private String buyTime;
    }
}
