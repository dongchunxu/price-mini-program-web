package com.dianwoyin.price.service;

import com.dianwoyin.price.vo.response.category.CategoryListResponse;
import com.dianwoyin.price.vo.response.category.CategoryPropListResponse;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface CategoryPropertyService {

    /**
     * 根据categoryId获取所有的配置集合
     * @param categoryId
     * @return
     */
    CategoryPropListResponse getPropertyListByCategoryId(Integer categoryId);


}
