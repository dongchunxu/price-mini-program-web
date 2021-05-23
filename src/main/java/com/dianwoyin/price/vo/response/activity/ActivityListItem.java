package com.dianwoyin.price.vo.response.activity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Getter
@ApiModel("活动列表item")
public class ActivityListItem {
    @ApiModelProperty("活动图片")
    private String activityImgUrl;

    @ApiModelProperty("活动名称")
    private String activityName;

    @ApiModelProperty("活动价格")
    private BigDecimal activityPrice;

    @ApiModelProperty("供应商名称")
    private String supplierName;

    @ApiModelProperty("截止时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date activityEndTime;

    @ApiModelProperty("供应商头像url")
    private String supplierAvatar;

    @ApiModelProperty("类目id")
    private Integer categoryId;
}
