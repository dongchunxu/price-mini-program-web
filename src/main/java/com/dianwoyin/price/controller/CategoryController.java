package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.CategoryService;
import com.dianwoyin.price.vo.response.CategoryListResponse;
import com.dianwoyin.price.vo.BizBaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
@RestController
@RequestMapping("/api/category")
@Api(tags = "品类")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("获取所有分类")
    @GetMapping("/getAllCategoryList")
    public BizBaseResponse<List<CategoryListResponse>> getAllCategoryList() {
        return BizBaseResponse.ok(categoryService.getAllCategoryList());
    }
}
