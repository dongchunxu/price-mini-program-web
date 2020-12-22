package com.dianwoyin.price.api;

import com.dianwoyin.price.vo.response.CategoryResponseVO;

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
    CategoryResponseVO getPropertyListByCategoryId(Integer categoryId);


}
