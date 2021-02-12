package com.dianwoyin.price.service;

import com.dianwoyin.price.api.CategoryPropertyService;
import com.dianwoyin.price.api.RedisService;
import com.dianwoyin.price.constants.RedisCacheKey;
import com.dianwoyin.price.vo.response.PropResponse;
import com.dianwoyin.price.vo.response.PropValueResponse;
import com.dianwoyin.price.vo.response.CategoryResponse;
import com.dianwoyin.price.entity.CategoryProperty;
import com.dianwoyin.price.entity.CategoryPropertyValue;
import com.dianwoyin.price.mapper.CategoryPropertyMapper;
import com.dianwoyin.price.mapper.CategoryPropertyValueMapper;
import com.dianwoyin.price.utils.PriceBeanUtils;
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
    public CategoryResponse getPropertyListByCategoryId(Integer categoryId) {
        String key = RedisCacheKey.CATEGORY_PROPERTY_VALUE + "_" + categoryId;
        CategoryResponse retObj = redisService.getObject(key, CategoryResponse.class);
        if (retObj != null) {
            return retObj;
        }

        // 查询类目下的所有属性
        List<CategoryProperty> categoryPropList = categoryPropertyMapper.selectByCategoryId(categoryId);
        List<PropResponse> categoryPropRespVOList =
                PriceBeanUtils.copyProperty(categoryPropList, PropResponse.class);
        if (CollectionUtils.isEmpty(categoryPropRespVOList)) {
            return null;
        }

        // 查询属性下的所有属性值
        List<Integer> propIdList = categoryPropRespVOList.stream().map(PropResponse::getId).collect(Collectors.toList());
        List<CategoryPropertyValue> propValueList = categoryPropertyValueMapper.selectByPropertyIds(propIdList);
        List<PropValueResponse> propValueRespVOList = PriceBeanUtils.copyProperty(propValueList, PropValueResponse.class);

        // 按propId分组
        Map<Integer, List<PropValueResponse>> propIdToPropValueMap = propValueRespVOList.stream()
                .collect(Collectors.groupingBy(PropValueResponse::getPropertyId));
        categoryPropRespVOList.forEach(e-> e.setPropertyValueResponseList(propIdToPropValueMap.get(e.getId())));

        retObj = new CategoryResponse();
        retObj.setPropResponseList(categoryPropRespVOList);
        redisService.setObject(key, retObj);
        return retObj;
    }
}
