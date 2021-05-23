package com.dianwoyin.price.service;

import com.dianwoyin.price.vo.response.category.CategoryListResponse;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
public interface CategoryService {

    /**
     * 获取所有的类目树
     * @return
     */
    List<CategoryListResponse> getAllCategoryList();

}
