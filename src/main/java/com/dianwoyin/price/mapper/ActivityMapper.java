package com.dianwoyin.price.mapper;

import com.dianwoyin.price.entity.Activity;

/**
 * @author chunxu.dong
 * @date 2020/12/12
 */
public interface ActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
}