package com.dianwoyin.price.service;

import com.dianwoyin.price.api.CategoryPropertyService;
import com.dianwoyin.price.vo.response.CategoryPropResponseVO;
import com.dianwoyin.price.vo.response.CategoryPropValueResponseVO;
import com.dianwoyin.price.vo.response.CategoryResponseVO;
import com.dianwoyin.price.entity.CategoryProperty;
import com.dianwoyin.price.entity.CategoryPropertyValue;
import com.dianwoyin.price.mapper.CategoryPropertyMapper;
import com.dianwoyin.price.mapper.CategoryPropertyValueMapper;
import com.dianwoyin.price.utils.BaseBeanUtils;
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
    
    @Override
    public CategoryResponseVO getPropertyListByCategoryId(Integer categoryId) {
        if (categoryId ==  null || categoryId < 0) {
            return null;
        }
        // 查询类目下的所有属性
        List<CategoryProperty> categoryPropList = categoryPropertyMapper.selectByCategoryId(categoryId);
        List<CategoryPropResponseVO> categoryPropResponseVOList =
                BaseBeanUtils.copyProperty(categoryPropList, CategoryPropResponseVO.class);
        if (CollectionUtils.isEmpty(categoryPropResponseVOList)) {
            return null;
        }

        // 查询属性下的所有属性值
        List<Integer> propIdList
                = categoryPropResponseVOList.stream().map(CategoryPropResponseVO::getId).collect(Collectors.toList());
        List<CategoryPropertyValue> propValueList
                = categoryPropertyValueMapper.selectByPropertyIds(propIdList);
        List<CategoryPropValueResponseVO> propValueRespBOList
                = BaseBeanUtils.copyProperty(propValueList, CategoryPropValueResponseVO.class);

        // 按propId分组
        Map<Integer, List<CategoryPropValueResponseVO>> propIdToPropValueMap = propValueRespBOList.stream()
                .collect(Collectors.groupingBy(CategoryPropValueResponseVO::getPropertyId));

        categoryPropResponseVOList.forEach(e-> e.setPropertyValueResponseBOS(propIdToPropValueMap.get(e.getId())));

        return CategoryResponseVO
                .builder().categoryPropResponseVOList(categoryPropResponseVOList)
                .build();
    }
}
