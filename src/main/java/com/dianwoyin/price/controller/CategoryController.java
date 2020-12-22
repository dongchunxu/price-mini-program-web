package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.CategoryService;
import com.dianwoyin.price.vo.response.CategoryListResponseVO;
import com.dianwoyin.price.vo.ResponseBaseVO;
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
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("获取所有分类")
    @GetMapping("/getAllCategoryList")
    public ResponseBaseVO<List<CategoryListResponseVO>> getAllCategoryList() {
        return ResponseBaseVO.ok(categoryService.getAllCategoryList());
    }
}
