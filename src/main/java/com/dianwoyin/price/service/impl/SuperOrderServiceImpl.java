package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.constants.enums.OrderStatusEnum;
import com.dianwoyin.price.model.*;
import com.dianwoyin.price.respository.*;
import com.dianwoyin.price.service.SuperOrderService;
import com.dianwoyin.price.vo.request.OrderCreateRequest;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.order.OrderDetailResponse;
import com.dianwoyin.price.vo.response.order.OrderListItemResponse;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2021/5/25
 */
@Slf4j
@Service
public class SuperOrderServiceImpl implements SuperOrderService {


    @Autowired
    private SuperOrderRepository superOrderRepository;

    @Autowired
    private PriceListRepository priceListRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PageResult<OrderListItemResponse> getOrderList(Integer userId, Integer orderStatus,
                                                          Integer page, Integer pageSize) {

        PageResult<SuperOrder> pageResult = superOrderRepository.getOrderList(userId, orderStatus, page, pageSize);

        if (CollectionUtils.isEmpty(pageResult.getResults())) {
            return PageResult.of(Collections.emptyList(), page, pageSize, pageResult.getTotal());
        }

        return PageResult.of(transferOrderListItemResponse(pageResult), page, pageSize, pageResult.getTotal());
    }

    private List<OrderListItemResponse> transferOrderListItemResponse(PageResult<SuperOrder> pageResult) {
        List<SuperOrder> superOrders = pageResult.getResults();

        List<OrderListItemResponse> itemResponses = superOrders.stream().map(e -> {
            OrderListItemResponse itemResponse = new OrderListItemResponse();
            BeanUtils.copyProperties(e, itemResponse);
            return itemResponse;
        }).collect(Collectors.toList());
        return itemResponses;
    }

    @Override
    public OrderDetailResponse getOrderDetail(Integer orderId, Integer operator) {
        SuperOrder superOrder = superOrderRepository.getOrderById(orderId, operator);
        return transferOrderDetailResponse(superOrder);
    }

    private OrderDetailResponse transferOrderDetailResponse(SuperOrder superOrder) {
        return null;
    }

    @Override
    public Boolean deleteOrder(Integer orderId, Integer operator) {
        return superOrderRepository.deleteOrder(orderId, operator);
    }

    @Override
    public Boolean confirmReceipt(Integer orderId, Integer operator) {
        return superOrderRepository.confirmReceipt(orderId, operator);
    }

    @Override
    public Boolean createOrder(OrderCreateRequest request, Integer operator) {
        Integer referId = request.getReferId();

        String goodsName;
        String goodsImgUrl;

        // 活动
        if (request.getChannel() == 1) {
            Activity activity = activityRepository.queryActivityById(referId);
            if (activity == null) {
                throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "当前活动已失效~");
            }

            goodsName = activity.getActivityName();

            String imgUrls = activity.getImgUrls();
            if (StringUtils.isNotBlank(imgUrls)) {
                goodsImgUrl = imgUrls.split(",")[0];
            } else {
                // todo 默认图
                goodsImgUrl = "";
            }
        }
        // 报价单
        else {
            PriceListAsk priceListAsk = priceListRepository.getPriceListAsk(referId);
            if (priceListAsk == null) {
                throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "当前报价单不存在~");
            }

            goodsName = priceListAsk.getName();

            CategoryDict categoryDict = categoryRepository.queryCategroyById(priceListAsk.getCategoryId());
            if (categoryDict == null) {
                throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "当前类目不存在~");
            }
            goodsImgUrl = categoryDict.getImgUrl();
        }

        Merchant merchant = merchantRepository.queryMerchantByUserId(operator + "");
        String addressDetail = merchant.getAddressDetail();
        String province = merchant.getProvince();
        String city = merchant.getCity();
        String district = merchant.getDistrict();
        String receiverPhone = merchant.getReceiverPhone();
        String receiverName = merchant.getReceiverName();

        SuperOrder superOrder = new SuperOrder();
        superOrder.setOrderNo(NumUtils.randomNum("DW", 8));
        superOrder.setReceiverPhone(receiverPhone);
        superOrder.setReceiverName(receiverName);
        superOrder.setReceiverAddress(province + city + district);
        superOrder.setReceiverAddressDetail(addressDetail);
        superOrder.setGoodsName(goodsName);
        superOrder.setGoodsImgUrl(goodsImgUrl);
        superOrder.setDeleted(false);
        superOrder.setCreatedId(operator);
        superOrder.setStatus(OrderStatusEnum.WaitPay.getCode());
        superOrder.setCreateTime(LocalDateTime.now());
        superOrder.setUpdateTime(LocalDateTime.now());
        superOrderRepository.createOrder(superOrder);
        return true;
    }
}