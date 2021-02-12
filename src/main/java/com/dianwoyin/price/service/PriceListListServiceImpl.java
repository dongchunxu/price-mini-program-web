package com.dianwoyin.price.service;

import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.api.CategoryPropertyService;
import com.dianwoyin.price.api.PriceListService;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.vo.request.AskPriceRequest;
import com.dianwoyin.price.vo.request.PropertyRequest;
import com.dianwoyin.price.vo.response.CategoryResponse;
import com.dianwoyin.price.vo.response.PropResponse;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2020/12/29
 */
@Service
public class PriceListListServiceImpl implements PriceListService {

    @Autowired
    private CategoryPropertyService categoryPropertyService;


    @Override
    @Transactional
    public Boolean createAskPrice(AskPriceRequest askPriceRequest) {
        // 校验表单必填项
        checkFormComplete(askPriceRequest);



        return null;
    }

    private void checkFormComplete(AskPriceRequest askPriceRequest) {
        // 查询类目的属性定义
        CategoryResponse categoryRespVO = categoryPropertyService.getPropertyListByCategoryId(askPriceRequest.getCategoryId());
        if (categoryRespVO == null || CollectionUtils.isEmpty(categoryRespVO.getPropResponseList())) {
            throw new BusinessException(ErrorCodeEnum.ERROR_ASK_PRICE_CREATE);
        }

        List<PropResponse> propRespVOList = categoryRespVO.getPropResponseList();
        Map<Integer, PropResponse> propIdToPropMap = propRespVOList.stream().collect(
                Collectors.toMap(PropResponse::getId, Function.identity(), (e1, e2) -> e1));

        List<PropertyRequest> propertyReqVOList = askPriceRequest.getPropertyRequestList();
        propertyReqVOList.forEach(propReq->{
            PropResponse propResponse = propIdToPropMap.get(propReq.getPropId());

            // 属性是否存在
            if (propResponse == null) {
                throw new BusinessException(ErrorCodeEnum.ERROR_ASK_PRICE_CREATE);
            }

            // 属性值是否必填
            if (propResponse.getMust()
                    && StringUtils.isEmpty(propReq.getPropValue()) && propReq.getPropValueId() == null) {
                throw new BusinessException(ErrorCodeEnum.ERROR_ASK_PRICE_CREATE);
            }
        });
    }
}
