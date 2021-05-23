package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.service.CategoryService;
import com.dianwoyin.price.service.RedisService;
import com.dianwoyin.price.entity.CategoryDict;
import com.dianwoyin.price.mapper.CategoryDictMapper;
import com.dianwoyin.price.utils.ConvertUtils;
import com.dianwoyin.price.vo.response.category.CategoryListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDictMapper categoryDictMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public List<CategoryListResponse> getAllCategoryList() {
//        List<CategoryListResponse> ret = redisService.getObject(RedisCacheKey.CATEGORY_ALL, List.class);
//        if (!CollectionUtils.isEmpty(ret)) {
//            return ret;
//        }

        List<CategoryListResponse> ret = new ArrayList<>();
                // 获取全量的类目信息
        List<CategoryDict> categoryDictList = categoryDictMapper.selectList();

        List<CategoryListResponse> categoryDictResponseList = ConvertUtils.convert(categoryDictList);
        if (CollectionUtils.isEmpty(categoryDictResponseList)) {
            return Collections.emptyList();
        }

        // 获取一级类目
        ret = categoryDictResponseList.stream().filter(e->e.getParentId().equals(0)).collect(Collectors.toList());
        ret.forEach(e->findChild(categoryDictResponseList, e));
//        redisService.setObject(RedisCacheKey.CATEGORY_ALL, ret);
        return ret;
    }


    private void findChild(List<CategoryListResponse> allCategory, CategoryListResponse curr) {
        if (CollectionUtils.isEmpty(allCategory)) {
            return;
        }
        List<CategoryListResponse> childrenList = allCategory.stream()
                .filter(e -> e.getParentId().equals(curr.getId())).collect(Collectors.toList());
        curr.setChildren(childrenList);
        childrenList.forEach(e-> findChild(allCategory, e));
    }
}
