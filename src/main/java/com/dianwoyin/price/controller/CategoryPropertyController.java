package com.dianwoyin.price.controller;

import com.dianwoyin.price.vo.ResponseBaseVO;
import com.dianwoyin.price.vo.response.CategoryListResponseVO;
import com.dianwoyin.price.vo.response.CategoryPropResponseVO;
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
public class CategoryPropertyController {

    @ApiOperation("获取属性和属性值")
    @GetMapping("/getCategoryPropPropValue")
    public ResponseBaseVO<Map<Integer, List<CategoryPropResponseVO>>> getCategoryPropPropValue(Integer categoryId) {
        return ResponseBaseVO.ok(null);
    }
}
