package com.dianwoyin.price.service;

import com.dianwoyin.price.api.CategoryPropertyService;
import com.dianwoyin.price.api.RedisService;
import com.dianwoyin.price.entity.CategoryProperty;
import com.dianwoyin.price.entity.CategoryPropertyValue;
import com.dianwoyin.price.mapper.CategoryPropertyMapper;
import com.dianwoyin.price.mapper.CategoryPropertyValueMapper;
import com.dianwoyin.price.utils.PriceBeanUtils;
import com.dianwoyin.price.vo.response.CategoryPropListResponse;
import com.dianwoyin.price.vo.response.CategoryPropValueResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Service
@Slf4j
public class CategoryPropertyServiceImpl implements CategoryPropertyService {

    @Autowired
    private CategoryPropertyMapper categoryPropertyMapper;
    @Autowired
    private CategoryPropertyValueMapper categoryPropertyValueMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public CategoryPropListResponse getPropertyListByCategoryId(Integer categoryId) {
//        String key = RedisCacheKey.CATEGORY_PROPERTY_VALUE + "_" + categoryId;
//        CategoryPropResponse retObj = redisService.getObject(key, CategoryPropResponse.class);
//        if (retObj != null) {
//            return retObj;
//        }

        // 查询类目下的所有属性
        List<CategoryProperty> categoryProps = categoryPropertyMapper.selectByCategoryId(categoryId);
        List<CategoryPropListResponse.CategoryPropListItem> categoryPropRespons = PriceBeanUtils.copyProperty(categoryProps, CategoryPropListResponse.CategoryPropListItem.class);
        if (CollectionUtils.isEmpty(categoryPropRespons)) {
            return null;
        }

        // 查询属性下的所有属性值
        List<Integer> propIds = categoryPropRespons.stream().map(CategoryPropListResponse.CategoryPropListItem::getId).collect(Collectors.toList());
        List<CategoryPropertyValue> propValues = categoryPropertyValueMapper.selectByPropertyIds(propIds);
        List<CategoryPropValueResponse> categoryPropValueRespons = PriceBeanUtils.copyProperty(propValues, CategoryPropValueResponse.class);

        // 按propId分组
        Map<Integer, List<CategoryPropValueResponse>> propIdToPropValueMap = categoryPropValueRespons.stream().collect(Collectors.groupingBy(CategoryPropValueResponse::getPropertyId));
        categoryPropRespons.forEach(e-> e.setPropValues(propIdToPropValueMap.get(e.getId())));

//        redisService.setObject(key, retObj);
        return CategoryPropListResponse.builder().mustProps(categoryPropRespons).build();
    }
}
