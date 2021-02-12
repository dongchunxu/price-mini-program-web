package com.dianwoyin.price.api;

import com.dianwoyin.price.vo.request.AskPriceRequest;

/**
 * @author chunxu.dong
 * @date 2020/12/29
 */
public interface PriceListService {

    Boolean createAskPrice(AskPriceRequest askPriceRequest);
}
