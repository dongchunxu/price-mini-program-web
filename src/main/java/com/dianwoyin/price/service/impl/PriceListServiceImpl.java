package com.dianwoyin.price.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.constants.enums.PriceListStatusEnum;
import com.dianwoyin.price.model.PriceListAsk;
import com.dianwoyin.price.respository.PriceListRepository;
import com.dianwoyin.price.service.CategoryPropertyService;
import com.dianwoyin.price.service.PriceListService;
import com.dianwoyin.price.utils.DateUtils;
import com.dianwoyin.price.vo.request.PriceListCreateRequest;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.category.CategoryPropListItem;
import com.dianwoyin.price.vo.response.category.CategoryPropListResponse;
import com.dianwoyin.price.vo.response.category.CategoryPropValueResponse;
import com.dianwoyin.price.vo.response.price.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2020/12/29
 */
@Service
public class PriceListServiceImpl implements PriceListService {
    
    private static final int MAX_ASK_COUNT_DAILY = 10;
    
    @Autowired
    private CategoryPropertyService categoryPropertyService;

    @Autowired
    private PriceListRepository priceListRepository;

    @Override
    public Boolean createPriceList(PriceListCreateRequest request, Integer userId) {
        List<PriceListAsk> priceListAsks = priceListRepository.getPriceListAskByUserIdAndCreatedTime(userId,
                DateUtils.getStartTimeOfDay(new Date(), 0), DateUtils.getEndTimeOfDay(new Date(), 0));
        if (!CollectionUtils.isEmpty(priceListAsks)) {
            int size = priceListAsks.size();
            if (size > MAX_ASK_COUNT_DAILY) {
                throw new BusinessException(ErrorCodeEnum.ERROR_SMS_CODE.getCode(), "今天您的询价过多~");
            }
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
        PageResult<PriceListAsk> pageResult = priceListRepository.getPriceListAskByUserIdPage(userId, priceListStatus, page, pageSize);

        List<PriceListListItemResponse> itemResponses = new ArrayList<>();
        List<PriceListAsk> results = pageResult.getResults();

        if (CollectionUtils.isEmpty(results)) {
            return PageResult.of(itemResponses, page, pageSize, pageResult.getTotal());
        }

        List<PriceListListItemResponse> collect = results.stream()
                .map(e -> {
                    // 报价单内容,json格式
                    JSONObject contentJson = JSON.parseObject(e.getContent());

                    // 解析报价单列表item标题
                    StringBuilder goodsName = new StringBuilder("");
                    CategoryPropListResponse categoryPropListResp =
                            categoryPropertyService.getPropertyListByCategoryId(e.getCategoryId());
                    List<CategoryPropListItem> basicProps = categoryPropListResp.getBasicProps();
                    basicProps.forEach(p->{
                        if (contentJson.containsKey(p.getId()+"")) {
                            JSONArray propValueJsonArr = contentJson.getJSONArray(p.getId() + "");
                            if (propValueJsonArr != null && propValueJsonArr.size() > 0) {
                                for (int i = 0; i < propValueJsonArr.size(); i++) {
                                    List<CategoryPropValueResponse> propValues = p.getPropValues();
                                    if (!CollectionUtils.isEmpty(propValues)) {
                                        for (CategoryPropValueResponse pv : propValues) {
                                            if (((Integer)propValueJsonArr.get(i)).equals(pv.getId())) {
                                                goodsName.append(pv.getPropertyValueName());
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    });

                    return PriceListListItemResponse.builder()
                            .priceListStatus(e.getStatus())
                            .priceListId(e.getId())
                            .createTime(Date.from(e.getCreateTime().atZone(ZoneId.systemDefault()).toInstant()))
                            .goodsImgUrl("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdimg.52bjw.cn%2Fimage%2Fupload%2Fcb%2F6a%2F13%2Fb3%2Fcb6a13b3fa90bdb998dbe693b3ad8846.jpg&refer=http%3A%2F%2Fdimg.52bjw.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624438821&t=81313fd79de1267c6fadc5812ca2a955")
                            .goodsName(goodsName.toString())
                            .payAmount(BigDecimal.valueOf(12, 2))
                            .build();
                })
                .collect(Collectors.toList());
        itemResponses.addAll(collect);
        return PageResult.of(itemResponses, page, pageSize, pageResult.getTotal());
    }

    @Override
    public PriceListDetailResponse getPriceListDetail(Integer priceListId) {
        GoodsDetail goodsDetail = new GoodsDetail();
        List<SimplePropPair> props = new ArrayList<>();
        props.add(new SimplePropPair("材料", "尼龙"));
        props.add(new SimplePropPair("尺寸", "10&12正开"));
        props.add(new SimplePropPair("数量", "1000"));
        props.add(new SimplePropPair("印面", "单面"));
        props.add(new SimplePropPair("工艺", "双面亮膜"));
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
    public Boolean confirmPrice(Integer priceListId, Integer priceListReplyId, String operator) {
        return true;
    }
}
