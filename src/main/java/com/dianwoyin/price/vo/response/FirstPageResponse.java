package com.dianwoyin.price.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("首页整体包装对象")
public class FirstPageResponse implements Serializable {

    @ApiModelProperty("热搜items")
    private List<HotHitItem> hotHitItems;

    @ApiModelProperty("热门活动items")
    private List<HotActivityItem> hotActivityItems;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel("热门活动item")
    public static class HotActivityItem implements Serializable {

        @ApiModelProperty("头图")
        private String headImgUrl;

        @ApiModelProperty("活动名称")
        private String activityName;

        @ApiModelProperty("活动价格")
        private String activityPrice;

        @ApiModelProperty("供应商名称")
        private String supplierName;

        @ApiModelProperty("截止时间")
        private Date activityEndTime;

        @ApiModelProperty("供应商头像url")
        private String supplierAvatar;

        @ApiModelProperty("类目id")
        private Integer categoryId;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel("热搜item")
    public static class HotHitItem implements Serializable {
        @ApiModelProperty("id")
        private Integer id;

        @ApiModelProperty("名称")
        private String name;

        @ApiModelProperty("类型，1：类目（当前只支持）")
        private Integer type;
    }

}
