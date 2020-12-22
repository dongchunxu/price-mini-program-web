package com.dianwoyin.price.mapper;

import com.dianwoyin.price.entity.TagDict;

/**
 * @author chunxu.dong
 * @date 2020/12/12
 */
public interface TagDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagDict record);

    int insertSelective(TagDict record);

    TagDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagDict record);

    int updateByPrimaryKey(TagDict record);
}