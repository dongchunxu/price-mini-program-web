package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.CategoryPropertyService;
import com.dianwoyin.price.api.CategoryService;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.response.CategoryListResponse;
import com.dianwoyin.price.vo.response.CategoryPropResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/22
 */
@RestController
@RequestMapping("/api")
@Api(tags = "通用接口")
public class CommonController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryPropertyService categoryPropertyService;

    @ApiOperation("获取所有分类")
    @GetMapping("/category/get-all-category-list")
    public BizBaseResponse<List<CategoryListResponse>> getAllCategoryList() {
        return BizBaseResponse.ok(categoryService.getAllCategoryList());
    }

    @ApiOperation("获取属性和属性值")
    @GetMapping("/prop/get-prop-value-by-category-id/{categoryId}")
    public BizBaseResponse<CategoryPropResponse> getCategoryPropPropValueByCategoryId(@ApiParam("类目id") @PathVariable Integer categoryId) {
        CategoryPropResponse categoryPropResponse = categoryPropertyService.getPropertyListByCategoryId(categoryId);
        return BizBaseResponse.ok(categoryPropResponse);
    }

}
