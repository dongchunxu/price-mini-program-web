package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.dto.LocationDTO;
import com.dianwoyin.price.dto.MerchantDTO;
import com.dianwoyin.price.model.Merchant;
import com.dianwoyin.price.respository.MerchantRepository;
import com.dianwoyin.price.service.LocationRemoteService;
import com.dianwoyin.price.service.MerchantService;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.constants.enums.MerchantStatusEnum;
import com.dianwoyin.price.utils.PriceBeanUtils;
import com.dianwoyin.price.vo.request.MerchantCreateRequest;
import com.dianwoyin.price.vo.request.MerchantUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private LocationRemoteService locationRemoteService;

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public Boolean createMerchant(MerchantCreateRequest request) {

        try {
            Merchant merchant = PriceBeanUtils.copyProperty(request, Merchant.class);
            LocationDTO location = locationRemoteService.getLocation(
                    request.getLongitude(), request.getLatitude());
            if (location == null) {
                throw new BusinessException(ErrorCodeEnum.ERROR_SMS_CODE.getCode(), "获取定位失败");
            }
            merchant.setProvince(location.getProvince());
            merchant.setCity(location.getCity());
            merchant.setDistrict(location.getDistrict());
            merchant.setStreet(location.getStreet());
            merchant.setFormattedAddress(location.getProvince() + location.getCity() + location.getDistrict());
            merchant.setCreateTime(LocalDateTime.now());
            merchant.setUpdateTime(LocalDateTime.now());
            merchant.setDeleted(false);
            // 初始状态为待审核
            merchant.setStatus(MerchantStatusEnum.Auditing.getCode());
            merchantRepository.addMerchant(merchant);
        } catch (Exception e) {
            log.error("create merchant error", e);
            throw new BusinessException(ErrorCodeEnum.ERROR_MERCHANT_CREATE);
        }
        return true;
    }

    @Override
    public Boolean updateMerchant(MerchantUpdateRequest request) {
        try {
            Merchant merchant = PriceBeanUtils.copyProperty(request, Merchant.class);
            //  包装定位信息
            LocationDTO location = locationRemoteService.getLocation(
                    request.getLongitude(), request.getLatitude());
            if (location == null) {
                throw new BusinessException(ErrorCodeEnum.ERROR_SMS_CODE.getCode(), "获取定位失败");
            }
            merchant.setProvince(location.getProvince());
            merchant.setCity(location.getCity());
            merchant.setDistrict(location.getDistrict());
            merchant.setStreet(location.getStreet());
            merchant.setFormattedAddress(location.getProvince() + location.getCity() + location.getDistrict());
            merchantRepository.updateMerchantGeoInfo(merchant);
        } catch (Exception e) {
            log.error("update merchant error", e);
            throw new BusinessException(ErrorCodeEnum.ERROR_MERCHANT_UPDATE);
        }
        return true;
    }

    @Override
    public MerchantDTO getMerchant(String userId) {
        Merchant merchant = merchantRepository.queryMerchantByUserId(userId);
        return PriceBeanUtils.copyProperty(merchant, MerchantDTO.class);
    }

}
