package com.dianwoyin.price.controller;

import com.dianwoyin.price.service.ActivityService;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.response.activity.ActivityDetailResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@RestController
@RequestMapping("/api/activity")
@Api(tags = "热门活动服务")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/get-activity-detail-by-id/{activityId}")
    @ApiOperation("根据类目id获取热门活动列表")
    public BizBaseResponse<ActivityDetailResponse> getActivityDetailById(@ApiParam("活动id") @PathVariable Integer activityId) {
        return BizBaseResponse.success(activityService.getActivityDetail(activityId));
    }


}
