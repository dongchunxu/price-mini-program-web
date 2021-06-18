package com.dianwoyin.price.service;

import com.dianwoyin.price.dto.MerchantDTO;
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
    Boolean createMerchant(MerchantCreateRequest merchantCreateRequest);

    /**
     * 更新商户信息
     * @param merchantUpdateRequest
     * @return
     */
    Boolean updateMerchant(MerchantUpdateRequest merchantUpdateRequest);


    /**
     * 获取商户信息
     * */
    MerchantDTO getMerchant(String userId);
}
