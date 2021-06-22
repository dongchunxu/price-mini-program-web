package com.dianwoyin.price.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.constants.enums.PriceListStatusEnum;
import com.dianwoyin.price.model.PriceListAsk;
import com.dianwoyin.price.respository.CategoryPropertyRepository;
import com.dianwoyin.price.respository.PriceListRepository;
import com.dianwoyin.price.service.CategoryPropertyService;
import com.dianwoyin.price.service.CategoryService;
import com.dianwoyin.price.service.PriceListService;
import com.dianwoyin.price.utils.DateUtils;
import com.dianwoyin.price.vo.request.PriceListCreateRequest;
import com.dianwoyin.price.vo.request.PropValueCreateRequest;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.category.CategoryListResponse;
import com.dianwoyin.price.vo.response.category.CategoryPropListItem;
import com.dianwoyin.price.vo.response.category.CategoryPropListResponse;
import com.dianwoyin.price.vo.response.category.CategoryPropValueResponse;
import com.dianwoyin.price.vo.response.price.*;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2020/12/29
 */
@Service
@Slf4j
public class PriceListServiceImpl implements PriceListService {
    
    private static final int MAX_ASK_COUNT_DAILY = 10;
    
    @Autowired
    private CategoryPropertyService categoryPropertyService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PriceListRepository priceListRepository;

    @Override
    public Boolean createPriceList(PriceListCreateRequest request, Integer userId) {
        log.info("createPriceList.request: {}, userId: {}", request, userId);


        List<PriceListAsk> priceListAsks = priceListRepository.getPriceListAskByUserIdAndCreatedTime(userId,
                DateUtils.getStartTimeOfDay(new Date(), 0), DateUtils.getEndTimeOfDay(new Date(), 0));
        if (!CollectionUtils.isEmpty(priceListAsks) && priceListAsks.size() > MAX_ASK_COUNT_DAILY) {
            throw new BusinessException(ErrorCodeEnum.ERROR_SMS_CODE.getCode(), "今天您的询价过多~");
        }

        PriceListAsk priceListAsk = new PriceListAsk();
        priceListAsk.setName("");
        priceListAsk.setCategoryId(request.getCategoryId());
        priceListAsk.setCreatedId(userId);
        priceListAsk.setDeleted(false);
        priceListAsk.setStatus(PriceListStatusEnum.Going.getCode());
        priceListAsk.setContent(JSON.toJSONString(request.getPropValueMap()));
        priceListAsk.setCreatedBy(userId+"");
        priceListAsk.setCreateTime(LocalDateTime.now());
        priceListRepository.addPriceListAsk(priceListAsk);

        return true;
    }

    @Override
    public PageResult<PriceListListItemResponse> getPriceListList(Integer userId, Integer priceListStatus, Integer page, Integer pageSize) {
        log.info("getPriceListList.userId: {}, priceListStatus: {}, page: {}, pageSize: {}", userId, priceListStatus, page, pageSize);
        PageResult<PriceListAsk> pageResult = priceListRepository.getPriceListAskByUserIdPage(userId, priceListStatus, page, pageSize);

        List<PriceListListItemResponse> itemResponses = new ArrayList<>();
        List<PriceListAsk> results = pageResult.getResults();

        if (CollectionUtils.isEmpty(results)) {
            return PageResult.of(itemResponses, page, pageSize, pageResult.getTotal());
        }

        List<CategoryListResponse> allCategoryList = categoryService.getLeafCategoryList();
        Map<Integer, List<CategoryListResponse>> categoryMap = allCategoryList.stream().collect(Collectors.groupingBy(CategoryListResponse::getId));
        List<PriceListListItemResponse> collect = results.stream()
                .map(e -> {
                    // 标题
                    StringBuilder goodsName = new StringBuilder();
                    Map<String, String> propValueMap = parsePropValue(e.getCategoryId(), e.getContent());
                    List<String> propValues = propValueMap.values().stream().collect(Collectors.toList());
                    for (String propValue : propValues) {
                        goodsName.append(propValue).append("/");
                    }
                    String imgUrl = "";
                    List<CategoryListResponse> categoryListResponses = categoryMap.get(e.getCategoryId());
                    if (!CollectionUtils.isEmpty(categoryListResponses)) {
                        imgUrl = categoryListResponses.get(0).getImgUrl();
                    }
                    return PriceListListItemResponse.builder()
                            .priceListStatus(e.getStatus())
                            .priceListId(e.getId())
                            .createTime(Date.from(e.getCreateTime().atZone(ZoneId.systemDefault()).toInstant()))
                            .goodsImgUrl(imgUrl)
                            .goodsName(goodsName.toString())
                            .payAmount(BigDecimal.valueOf(12, 2))
                            .build();
                })
                .collect(Collectors.toList());
        itemResponses.addAll(collect);

        return PageResult.of(itemResponses, page, pageSize, pageResult.getTotal());
    }

    private Map<String, String> parsePropValue(Integer categoryId, String content) {
        Map<String, String> resultMap = new HashMap<>();

        CategoryPropListResponse categoryPropListResp = categoryPropertyService.getPropertyListByCategoryId(categoryId);
        List<CategoryPropListItem> basicPropsDict = categoryPropListResp.getBasicProps();
        List<CategoryPropListItem> otherPropsDict = categoryPropListResp.getOtherProps();

        Map<Integer, List<CategoryPropListItem>> basicPropValueMap
                = basicPropsDict.stream().collect(Collectors.groupingBy(CategoryPropListItem::getId));
        Map<Integer, List<CategoryPropListItem>> otherPropValueMap
                = otherPropsDict.stream().collect(Collectors.groupingBy(CategoryPropListItem::getId));

        PropValueCreateRequest propValueCreateRequest = JSON.parseObject(content, PropValueCreateRequest.class);
        final List<PropValueCreateRequest.Prop> basicProps1 = propValueCreateRequest.getBasicProps();
        final List<PropValueCreateRequest.Prop> otherProps = propValueCreateRequest.getOtherProps();

        if (!CollectionUtils.isEmpty(basicProps1)) {
           for (PropValueCreateRequest.Prop prop: basicProps1) {
               Integer propId = prop.getId();
               Object value = prop.getValue();
               JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(value));
               for (int i = 0; i < jsonArray.size(); i++) {
                   List<CategoryPropListItem> categoryPropListItems = basicPropValueMap.get(propId);
                   if (!CollectionUtils.isEmpty(categoryPropListItems)) {
                       CategoryPropListItem categoryPropListItem = categoryPropListItems.get(0);
                       List<CategoryPropValueResponse> propValues = categoryPropListItem.getPropValues();

                       Object o = jsonArray.get(i);
                       if (!CollectionUtils.isEmpty(propValues)) {
                           if (o instanceof Integer) {
                               if ("数量".equals(categoryPropListItem.getPropertyName())) {
                                   resultMap.put("数量", (String) o);
                               } else {
                                   propValues.forEach(f->{
                                       if (f.getId().equals(o)) {
                                           resultMap.put(categoryPropListItem.getPropertyName(), f.getPropertyValueName());
                                       }
                                   });
                               }
                           } else {
                               resultMap.put(categoryPropListItem.getPropertyName(), (String) o);
                           }
                       }
                   }
               }
           }
        }
        if (!CollectionUtils.isEmpty(otherProps)) {
            for (PropValueCreateRequest.Prop prop: otherProps) {
                Integer propId = prop.getId();
                Object value = prop.getValue();
                JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(value));
                for (int i = 0; i < jsonArray.size(); i++) {
                    List<CategoryPropListItem> categoryPropListItems = otherPropValueMap.get(propId);
                    if (!CollectionUtils.isEmpty(categoryPropListItems)) {
                        CategoryPropListItem categoryPropListItem = categoryPropListItems.get(0);
                        List<CategoryPropValueResponse> propValues = categoryPropListItem.getPropValues();

                        Object o = jsonArray.get(i);
                        if (!CollectionUtils.isEmpty(propValues)) {
                            if (o instanceof Integer) {
                                propValues.forEach(f->{
                                    if (f.getId().equals(o)) {
                                        resultMap.put(categoryPropListItem.getPropertyName(), f.getPropertyValueName());
                                    }
                                });
                            } else {
                                resultMap.put(categoryPropListItem.getPropertyName(), (String) o);
                            }
                        }
                    }
                }
            }
        }

        return resultMap;
    }

    @Override
    public PriceListDetailResponse getPriceListDetail(Integer priceListId) {
        PriceListAsk priceListAsk = priceListRepository.getPriceListAsk(priceListId);

        if (priceListAsk == null) {
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "报价单不存在哦~");
        }
        // 属性
        Map<String, String> propValueMap = parsePropValue(priceListAsk.getCategoryId(), priceListAsk.getContent());
        List<SimplePropPair> props = new ArrayList<>();
        propValueMap.forEach((propName, propValueName)->{
            props.add(new SimplePropPair(propName, propValueName));
        });

        GoodsDetail goodsDetail = new GoodsDetail();
        goodsDetail.setPropValues(props);
        goodsDetail.setComment("今天一定要送到哦！");

        DeliveryDetail deliveryDetail = new DeliveryDetail();
        deliveryDetail.setDeliveryChannel(0);
        deliveryDetail.setReceiverAddressDetail("3栋2单元");
        deliveryDetail.setReceiverAddress("江苏省扬州市汉江中路101号");
        deliveryDetail.setExpectDeliveryTime(new Date());

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderNo("xx-sss-12312313");
        orderDetail.setOrderCreateTime(new Date());
        orderDetail.setPayChannel(1);

        List<PriceListReplyDetail> priceListReplyList = new ArrayList<>();
        PriceListReplyDetail detail = new PriceListReplyDetail();
        detail.setAmount(BigDecimal.TEN);
        detail.setComment("你好");
        detail.setSupplierName("华东彩印");
        detail.setCreateTime(new Date());
        detail.setSupplierAvatar("https://t7.baidu.com/it/u=1831997705,836992814&fm=193&f=GIF");
        detail.setDeliveryTime(new Date());
        priceListReplyList.add(detail);

        return PriceListDetailResponse.builder()
                .priceListId(123)
                .priceListStatus(PriceListStatusEnum.Going.getCode())
                .goodsName("标准不干胶100张")
                .goodsImgUrl("")
                .goodsDetail(goodsDetail)
                .deliveryDetail(deliveryDetail)
                .payAmount(BigDecimal.valueOf(12313,2))
                .goodsDetail(goodsDetail)
                .orderDetail(orderDetail)
                .priceListReplyList(priceListReplyList)
                .createTime(new Date())
                .build();
    }

    @Override
    public Boolean confirmPrice(Integer priceListId, Integer priceListReplyId, Integer operator) {
        return priceListRepository.confirmPrice(priceListId, priceListReplyId, operator);
    }

    @Override
    public Boolean stopPrice(Integer priceListId, Integer operator) {
        return priceListRepository.stopPrice(priceListId, operator);
    }
}
