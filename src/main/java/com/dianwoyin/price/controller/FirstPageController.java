package com.dianwoyin.price.controller;

import com.dianwoyin.price.service.ActivityService;
import com.dianwoyin.price.service.FirstPageService;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.BizPageResponse;
import com.dianwoyin.price.vo.response.firstpage.ActivityItem;
import com.dianwoyin.price.vo.response.firstpage.FirstPageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@RestController
@RequestMapping("/api/first-page")
@Api(tags = "首页服务")
@CrossOrigin(origins = "*")
public class FirstPageController {

    @Autowired
    private FirstPageService firstPageService;

    @Autowired
    private ActivityService activityService;

    @ApiOperation("获取所有分类")
    @GetMapping("/get-first-page-config")
    public BizBaseResponse<FirstPageResponse> getFirstPageConfig(@RequestParam("cityId") Integer cityId) {
        return BizBaseResponse.success(firstPageService.getFirstPageConfig(cityId));
    }

    @ApiOperation("获取推荐活动")
    @GetMapping("/get-recommend-activity")
    public BizPageResponse<ActivityItem> getRecommendActivity(@RequestParam("categoryId") Integer categoryId,
                                                              @RequestParam("cityId") Integer cityId,
                                                              @RequestParam("page") Integer page,
                                                              @RequestParam("pageSize") Integer pageSize) {
        return BizPageResponse.success(activityService.getRecommendActivityPage(cityId, categoryId, page, pageSize));
    }


}
