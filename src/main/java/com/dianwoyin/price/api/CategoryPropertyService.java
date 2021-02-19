package com.dianwoyin.price.api;

import com.dianwoyin.price.vo.response.CategoryPropResponse;

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
    CategoryPropResponse getPropertyListByCategoryId(Integer categoryId);


}
