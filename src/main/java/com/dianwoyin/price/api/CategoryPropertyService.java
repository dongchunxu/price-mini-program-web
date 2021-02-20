package com.dianwoyin.price.api;

import com.dianwoyin.price.vo.response.CategoryPropListResponse;

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
