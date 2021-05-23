package com.dianwoyin.price.vo.response.firstpage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("首页整体包装对象")
@Builder
public class FirstPageResponse implements Serializable {

    @ApiModelProperty("热搜items")
    private List<HotCategoryItem> hotCategoryItems;

    @ApiModelProperty("热门活动items")
    private List<ActivityItem> activityItems;

    @ApiModelProperty("活动tabs")
    private List<ActivityTab> activityTabs;


}
