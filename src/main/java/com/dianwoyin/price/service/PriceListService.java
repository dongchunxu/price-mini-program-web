package com.dianwoyin.price.service;

import com.dianwoyin.price.vo.request.PriceListCreateRequest;

/**
 * @author chunxu.dong
 * @date 2020/12/29
 */
public interface PriceListService {

    Boolean createPriceList(PriceListCreateRequest request);
}
