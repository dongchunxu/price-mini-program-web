package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.DistrictService;
import com.dianwoyin.price.vo.response.DistrictListResponse;
import com.dianwoyin.price.constants.enums.DistrictLevelEnum;
import com.dianwoyin.price.vo.BizBaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
@RestController
@RequestMapping("/api/district")
@Api(tags = "行政区字典")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @ApiOperation("获取所有的城市")
    @GetMapping("/getAllCity")
    public BizBaseResponse<Map<String, List<DistrictListResponse>>> getAllCity() {
        return BizBaseResponse.ok(districtService.getDistrictByLevel(DistrictLevelEnum.City.getLevel()));
    }
}
