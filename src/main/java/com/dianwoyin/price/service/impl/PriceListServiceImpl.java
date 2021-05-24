package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.service.CategoryPropertyService;
import com.dianwoyin.price.service.PriceListService;
import com.dianwoyin.price.mapper.PriceListAskMapper;
import com.dianwoyin.price.vo.request.PriceListCreateRequest;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.price.PriceListListItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chunxu.dong
 * @date 2020/12/29
 */
@Service
public class PriceListServiceImpl implements PriceListService {

    @Autowired
    private CategoryPropertyService categoryPropertyService;

    @Autowired
    private PriceListAskMapper priceListAskMapper;

    @Override
    public Boolean createPriceList(PriceListCreateRequest request) {
        return true;
    }

    @Override
    public PageResult<PriceListListItemResponse> getPriceListList(Integer priceListStatus) {

        return null;
    }
}
