package com.dianwoyin.price.controller;

import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.response.HotActivityListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@RestController
@RequestMapping("/api/hot-activity")
@Api(tags = "热门活动服务")
public class HotActivityController {

    @GetMapping("/get-hot-activity-list-by-category-id/{categoryId}")
    @ApiOperation("根据类目id获取热门活动列表")
    public BizBaseResponse<HotActivityListResponse> getHotActivityListByCategoryId(@ApiParam("类目id") @PathVariable Integer categoryId) {
        return BizBaseResponse.ok(null);
    }


}
