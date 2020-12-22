package com.dianwoyin.price.mapper;

import com.dianwoyin.price.entity.CategoryDict;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/19
 */
public interface CategoryDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryDict record);

    int insertSelective(CategoryDict record);

    CategoryDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryDict record);

    int updateByPrimaryKey(CategoryDict record);

    List<CategoryDict> selectList();
}