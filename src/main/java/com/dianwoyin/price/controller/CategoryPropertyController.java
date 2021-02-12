package com.dianwoyin.price.controller;

import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.response.PropResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api/property")
@Api(tags = "品类属性")
public class CategoryPropertyController {

    @ApiOperation("获取属性和属性值")
    @GetMapping("/getCategoryPropPropValue")
    public BizBaseResponse<Map<Integer, List<PropResponse>>> getCategoryPropPropValue(Integer categoryId) {
        return BizBaseResponse.ok(null);
    }
}
