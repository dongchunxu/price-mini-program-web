package com.dianwoyin.price.respository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dianwoyin.price.mapper.CategoryPropertyMapper;
import com.dianwoyin.price.mapper.CategoryPropertyValueMapper;
import com.dianwoyin.price.model.CategoryProperty;
import com.dianwoyin.price.model.CategoryPropertyValue;
import com.dianwoyin.price.utils.PriceBeanUtils;
import com.dianwoyin.price.vo.response.category.CategoryPropListItem;
import com.dianwoyin.price.vo.response.category.CategoryPropListResponse;
import com.dianwoyin.price.vo.response.category.CategoryPropValueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2021/6/7
 */
@Repository
public class CategoryPropertyRepository {

    @Autowired
    private CategoryPropertyMapper categoryPropertyMapper;
    @Autowired
    private CategoryPropertyValueMapper categoryPropertyValueMapper;

    public CategoryPropListResponse getPropertyListByCategoryId(Integer categoryId) {
//        String key = RedisCacheKey.CATEGORY_PROPERTY_VALUE + "_" + categoryId;
//        CategoryPropResponse retObj = redisService.getObject(key, CategoryPropResponse.class);
//        if (retObj != null) {
//            return retObj;
//        }
        // 查询类目下的所有属性
        QueryWrapper<CategoryProperty> queryWrapper = new QueryWrapper();
        queryWrapper.eq("category_id", categoryId);
        List<CategoryProperty> categoryProps = categoryPropertyMapper.selectList(queryWrapper);
        List<CategoryPropListItem> props = PriceBeanUtils.copyProperty(categoryProps, CategoryPropListItem.class);
        if (CollectionUtils.isEmpty(props)) {
            return null;
        }

        // 查询属性下的所有属性值
        List<Integer> propIds = props.stream().map(CategoryPropListItem::getId).collect(Collectors.toList());
        QueryWrapper<CategoryPropertyValue> propValueQueryWrapper = new QueryWrapper();
        propValueQueryWrapper.in("property_id", propIds);

        List<CategoryPropertyValue> propValues = categoryPropertyValueMapper.selectList(propValueQueryWrapper);
        List<CategoryPropValueResponse> propValueResponses = PriceBeanUtils.copyProperty(propValues, CategoryPropValueResponse.class);

        // 按propId分组
        Map<Integer, List<CategoryPropValueResponse>> propIdToPropValueMap = propValueResponses.stream().collect(Collectors.groupingBy(CategoryPropValueResponse::getPropertyId));
        props.forEach(e-> e.setPropValues(propIdToPropValueMap.get(e.getId())));

//        redisService.setObject(key, retObj);
        return CategoryPropListResponse.builder()
                .basicProps(props.stream()
                        .filter(e->!"工艺".equals(e.getPropertyName())).
                        collect(Collectors.toList()))
                .otherProps(props.stream()
                        .filter(e-> "工艺".equals(e.getPropertyName())).
                                collect(Collectors.toList()))
                .build();
    }
}
