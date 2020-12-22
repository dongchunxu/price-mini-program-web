package com.dianwoyin.price.api;

import com.dianwoyin.price.vo.request.MerchantCreateRequestVO;
import com.dianwoyin.price.vo.request.MerchantUpdateRequestVO;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface MerchantService {

    /**
     * 创建商户
     * @param merchantCreateRequestVO
     * @return
     */
    Boolean create(MerchantCreateRequestVO merchantCreateRequestVO);

    /**
     * 更新商户信息
     * @param merchantUpdateRequestVO
     * @return
     */
    Boolean update(MerchantUpdateRequestVO merchantUpdateRequestVO);

}
