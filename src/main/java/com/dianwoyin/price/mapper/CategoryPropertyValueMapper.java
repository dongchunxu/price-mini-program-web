package com.dianwoyin.price.mapper;

import com.dianwoyin.price.entity.CategoryPropertyValue;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/12
 */
public interface CategoryPropertyValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryPropertyValue record);

    int insertSelective(CategoryPropertyValue record);

    CategoryPropertyValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryPropertyValue record);

    int updateByPrimaryKey(CategoryPropertyValue record);

    List<CategoryPropertyValue> selectByPropertyIds(List<Integer> propIds);
}