package com.dianwoyin.price.service;

import com.dianwoyin.price.vo.request.PriceListCreateRequest;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.price.PriceListListItemResponse;

/**
 * @author chunxu.dong
 * @date 2020/12/29
 */
public interface PriceListService {

    Boolean createPriceList(PriceListCreateRequest request);

    PageResult<PriceListListItemResponse> getPriceListList(Integer priceListStatus, Integer page, Integer pageSize);
}
