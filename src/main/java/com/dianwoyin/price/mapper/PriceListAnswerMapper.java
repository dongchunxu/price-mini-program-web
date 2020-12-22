package com.dianwoyin.price.mapper;

import com.dianwoyin.price.entity.PriceListAnswer;

/**
 * @author chunxu.dong
 * @date 2020/12/12
 */
public interface PriceListAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PriceListAnswer record);

    int insertSelective(PriceListAnswer record);

    PriceListAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PriceListAnswer record);

    int updateByPrimaryKey(PriceListAnswer record);
}