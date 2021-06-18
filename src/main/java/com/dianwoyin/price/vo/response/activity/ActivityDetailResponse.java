package com.dianwoyin.price.vo.response.activity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("活动详情")
@Builder
public class ActivityDetailResponse {

    @ApiModelProperty("活动id")
    private Integer activityId;

    @ApiModelProperty("活动图片,逗号分隔")
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

    @ApiModelProperty("供应商信息")
    private Supplier supplierInfo;

}
