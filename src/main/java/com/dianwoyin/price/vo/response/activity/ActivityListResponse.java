package com.dianwoyin.price.vo.response.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("活动列表")
public class ActivityListResponse {

    @ApiModelProperty("活动列表items")
    private List<ActivityListItem> activityListItems;


}
