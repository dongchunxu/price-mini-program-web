package com.dianwoyin.price.mapper;

import com.dianwoyin.price.entity.Merchant;

/**
 * @author chunxu.dong
 * @date 2020/12/12
 */
public interface MerchantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
}