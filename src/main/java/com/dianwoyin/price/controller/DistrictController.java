package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.DistrictService;
import com.dianwoyin.price.vo.response.DistrictListResponseVO;
import com.dianwoyin.price.constants.enums.DistrictLevelEnum;
import com.dianwoyin.price.vo.ResponseBaseVO;
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
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @ApiOperation("获取所有的城市")
    @GetMapping("/getAllCity")
    public ResponseBaseVO<Map<String, List<DistrictListResponseVO>>> getAllCity() {
        return ResponseBaseVO.ok(districtService.getDistrictByLevel(DistrictLevelEnum.CITY.getLevel()));
    }
}
