package com.dianwoyin.price.mapper;

import com.dianwoyin.price.entity.CategoryProperty;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/12
 */
public interface CategoryPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryProperty record);

    int insertSelective(CategoryProperty record);

    CategoryProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryProperty record);

    int updateByPrimaryKey(CategoryProperty record);

    List<CategoryProperty> selectByCategoryId(Integer categoryId);
}