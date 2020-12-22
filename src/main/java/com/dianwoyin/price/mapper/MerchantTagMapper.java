package com.dianwoyin.price.mapper;

import com.dianwoyin.price.entity.MerchantTag;

/**
 * @author chunxu.dong
 * @date 2020/12/12
 */
public interface MerchantTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantTag record);

    int insertSelective(MerchantTag record);

    MerchantTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantTag record);

    int updateByPrimaryKey(MerchantTag record);
}