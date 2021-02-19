package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.CategoryPropertyService;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.response.CategoryPropResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
@RestController
@RequestMapping("/api/prop")
@Api(tags = "品类属性")
public class CategoryPropertyController {

    @Autowired
    private CategoryPropertyService categoryPropertyService;

    @ApiOperation("获取属性和属性值")
    @GetMapping("/get-prop-value-by-category-id")
    public BizBaseResponse<CategoryPropResponse> getCategoryPropPropValueByCategoryId(@ApiParam("类目id") Integer categoryId) {
        CategoryPropResponse categoryPropResponse = categoryPropertyService.getPropertyListByCategoryId(categoryId);
        return BizBaseResponse.ok(categoryPropResponse);
    }
}
