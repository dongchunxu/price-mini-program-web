package com.dianwoyin.price.mapper;

import com.dianwoyin.price.entity.PriceListAsk;

/**
 * @author chunxu.dong
 * @date 2020/12/12
 */
public interface PriceListAskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PriceListAsk record);

    int insertSelective(PriceListAsk record);

    PriceListAsk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PriceListAsk record);

    int updateByPrimaryKey(PriceListAsk record);
}