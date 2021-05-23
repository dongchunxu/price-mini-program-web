package com.dianwoyin.price.controller;

import com.dianwoyin.price.service.FirstPageService;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.response.firstpage.FirstPageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@RestController
@RequestMapping("/api/first-page")
@Api(tags = "首页服务")
public class FirstPageController {

    @Autowired
    private FirstPageService firstPageService;

    @ApiOperation("获取所有分类")
    @GetMapping("/get-first-page")
    public BizBaseResponse<FirstPageResponse> getFirstPage(@RequestParam("cityId") Integer cityId) {
        return BizBaseResponse.ok(firstPageService.getFirstPage(cityId));
    }

}
