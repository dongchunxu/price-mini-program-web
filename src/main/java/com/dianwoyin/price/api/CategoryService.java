package com.dianwoyin.price.api;

import com.dianwoyin.price.vo.response.CategoryListResponseVO;

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
    List<CategoryListResponseVO> getAllCategoryList();

}
