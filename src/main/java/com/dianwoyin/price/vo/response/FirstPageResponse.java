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

    @ApiModelProperty("活动tabs")
    private List<ActivityTab> activityTabs;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel("活动tab配置")
    public static class ActivityTab implements Serializable {
        @ApiModelProperty("类目id")
        private String categoryId;
        @ApiModelProperty("类目名称")
        private Integer categoryName;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel("热门活动item")
    public static class HotActivityItem implements Serializable {
        @ApiModelProperty("活动图片")
        private String activityImgUrl;
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
        @ApiModelProperty("省份")
        private String province;
        @ApiModelProperty("城市")
        private String city;
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
