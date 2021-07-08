package com.dianwoyin.price.controller;

import com.dianwoyin.price.service.CategoryPropertyService;
import com.dianwoyin.price.service.CategoryService;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.response.category.CategoryListResponse;
import com.dianwoyin.price.vo.response.category.CategoryPropListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/22
 */
@RestController
@RequestMapping("/api/category")
@Api(tags = "品类服务")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryPropertyService categoryPropertyService;

    @ApiOperation("搜索分类")
    @GetMapping("/category/search")
    public BizBaseResponse<List<CategoryListResponse>> search(@ApiParam("关键词") String keyword) {
        return BizBaseResponse.success(null);
    }

    @ApiOperation("获取所有分类")
    @GetMapping("/get-all-category-list")
    public BizBaseResponse<List<CategoryListResponse>> getAllCategoryList() {
        return BizBaseResponse.success(categoryService.getAllCategoryList());
    }

    @ApiOperation("获取属性和属性值")
    @GetMapping("/get-prop-value-by-category-id/{categoryId}")
    public BizBaseResponse<CategoryPropListResponse> getCategoryPropPropValueByCategoryId(@ApiParam("类目id") @PathVariable Integer categoryId) {
        return BizBaseResponse.success(categoryPropertyService.getPropertyListByCategoryId(categoryId));
    }

}
