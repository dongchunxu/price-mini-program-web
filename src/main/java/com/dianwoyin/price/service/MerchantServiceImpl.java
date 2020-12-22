package com.dianwoyin.price.service;

import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.api.MerchantService;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.constants.enums.MerchantStatusEnum;
import com.dianwoyin.price.vo.request.MerchantCreateRequestVO;
import com.dianwoyin.price.vo.request.MerchantUpdateRequestVO;
import com.dianwoyin.price.entity.Merchant;
import com.dianwoyin.price.mapper.MerchantMapper;
import com.dianwoyin.price.utils.BaseBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public Boolean create(MerchantCreateRequestVO merchantCreateRequestVO) {

        try {
            Date now = new Date();

            Merchant merchant = BaseBeanUtils.copyProperty(merchantCreateRequestVO, Merchant.class);
            merchant.setCreateTime(now);
            merchant.setUpdateTime(now);
            merchant.setDeleted(false);
            // 初始状态为待审核
            merchant.setStatus(MerchantStatusEnum.AUDITING.getCode());

            merchantMapper.insert(merchant);
        } catch (Exception e) {
            log.error("create merchant error", e);
            throw new BusinessException(ErrorCodeEnum.ERROR_MERCHANT_CREATE);
        }

        return true;
    }

    @Override
    public Boolean update(MerchantUpdateRequestVO updateRequestVO) {
        try {
            Merchant merchant = BaseBeanUtils.copyProperty(updateRequestVO, Merchant.class);
            merchantMapper.updateByPrimaryKeySelective(merchant);
        } catch (Exception e) {
            log.error("update merchant error", e);
            throw new BusinessException(ErrorCodeEnum.ERROR_MERCHANT_UPDATE);
        }
        return true;
    }

}
