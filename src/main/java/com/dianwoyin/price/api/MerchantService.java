package com.dianwoyin.price.api;

import com.dianwoyin.price.vo.request.MerchantCreateRequest;
import com.dianwoyin.price.vo.request.MerchantUpdateRequest;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface MerchantService {

    /**
     * 创建商户
     * @param merchantCreateRequest
     * @return
     */
    Boolean create(MerchantCreateRequest merchantCreateRequest);

    /**
     * 更新商户信息
     * @param merchantUpdateRequest
     * @return
     */
    Boolean update(MerchantUpdateRequest merchantUpdateRequest);

}
