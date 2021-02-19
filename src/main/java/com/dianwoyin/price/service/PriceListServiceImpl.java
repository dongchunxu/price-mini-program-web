package com.dianwoyin.price.service;

import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.api.CategoryPropertyService;
import com.dianwoyin.price.api.PriceListService;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.mapper.PriceListAskMapper;
import com.dianwoyin.price.vo.request.PriceListCreateRequest;
import com.dianwoyin.price.vo.response.CategoryPropResponse;
import com.dianwoyin.price.vo.response.PropResponse;
import com.dianwoyin.price.vo.response.PropValueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
//        priceListAskMapper.insert(null);
        return true;
    }

//    private void validate(PriceListCreateRequest request) {
//        // 查询类目的属性和属性值定义
//        CategoryPropResponse propResponse = categoryPropertyService.getPropertyListByCategoryId(request.getCategoryId());
//        if (propResponse == null || CollectionUtils.isEmpty(request.getPropValueMap())) {
//            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM);
//        }
//
//        // 类目的必填属性
//        List<PropResponse> mustProps = propResponse.getMustProps();
//        Map<Integer, List<Integer>> mustPropMap = mustProps.stream().collect(
//                Collectors.toMap(PropResponse::getId,
//                        e-> e.getPropValues().stream().map(PropValueResponse::getId).collect(Collectors.toList()))
//        );
//
//        Map<Integer, String> propValueMap = request.getPropValueMap();
//        //todo
//    }
}
