package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.respository.CategoryPropertyRepository;
import com.dianwoyin.price.service.CategoryPropertyService;
import com.dianwoyin.price.service.RedisService;
import com.dianwoyin.price.vo.response.category.CategoryPropListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Service
@Slf4j
public class CategoryPropertyServiceImpl implements CategoryPropertyService {


    @Autowired
    private RedisService redisService;

    @Autowired
    private CategoryPropertyRepository categoryPropertyRepository;

    @Override
    public CategoryPropListResponse getPropertyListByCategoryId(Integer categoryId) {
//        String key = RedisCacheKey.CATEGORY_PROPERTY_VALUE + "_" + categoryId;
//        CategoryPropResponse retObj = redisService.getObject(key, CategoryPropResponse.class);
//        if (retObj != null) {
//            return retObj;
//        }
        return categoryPropertyRepository.getPropertyListByCategoryId(categoryId);
//        redisService.setObject(key, retObj);
    }
}
