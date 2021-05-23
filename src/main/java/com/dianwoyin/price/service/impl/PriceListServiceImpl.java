package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.service.CategoryPropertyService;
import com.dianwoyin.price.service.PriceListService;
import com.dianwoyin.price.mapper.PriceListAskMapper;
import com.dianwoyin.price.vo.request.PriceListCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
