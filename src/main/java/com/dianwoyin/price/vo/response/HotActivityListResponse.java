package com.dianwoyin.price.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
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
@ApiModel("热门活动列表")
public class HotActivityListResponse {

    @ApiModelProperty("热门活动列表items")
    private List<HotActivityListItem> hotActivityListItems;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel("热门活动列表item")
    public static class HotActivityListItem {
        @ApiModelProperty("头图")
        private String headImgUrl;

        @ApiModelProperty("活动名称")
        private String activityName;

        @ApiModelProperty("活动价格")
        private BigDecimal activityPrice;

        @ApiModelProperty("供应商名称")
        private String supplierName;

        @ApiModelProperty("截止时间")
        private Date activityEndTime;

        @ApiModelProperty("供应商头像url")
        private String supplierAvatar;

        @ApiModelProperty("类目id")
        private Integer categoryId;
    }



}
