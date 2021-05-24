package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.constants.enums.OrderStatusEnum;
import com.dianwoyin.price.service.OrderService;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.order.OrderDetailResponse;
import com.dianwoyin.price.vo.response.order.OrderListItemResponse;
import com.dianwoyin.price.vo.response.order.DeliveryDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/5/25
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public PageResult<OrderListItemResponse> getOrderList(Integer userId, Integer orderStatus,
                                                          Integer page, Integer pageSize) {
        List<OrderListItemResponse> dataList = new ArrayList<>();
        dataList.add(mock(1001, orderStatus));
        dataList.add(mock(1002, orderStatus));
        dataList.add(mock(1003, orderStatus));
        dataList.add(mock(1004, orderStatus));
        dataList.add(mock(1005, orderStatus));
        return PageResult.of(dataList, page, pageSize, dataList.size());
    }

    @Override
    public OrderDetailResponse getOrderDetail(Integer orderId) {
        OrderDetailResponse response = new OrderDetailResponse();
        response.setOrderId(orderId);
        response.setDeliveryTime(new Date());
        response.setGoodsName("普通不干胶100张【中秋节活动】");
        response.setGoodsImgUrl("");
        response.setOrderStatus(OrderStatusEnum.Finished.getCode());
        response.setFreightPrice(BigDecimal.ZERO);
        response.setOrderNo("1912-2313-3434");
        response.setGoodsPrice(BigDecimal.valueOf(212,2));
        response.setGoodsQty(12);
        response.setPayAmount(BigDecimal.valueOf(1222,2));
        response.setPayChannel(0);
        response.setPayTime(new Date());

        DeliveryDetail deliveryDetail = new DeliveryDetail();
        deliveryDetail.setDeliveryNo("SH123123132");
        deliveryDetail.setDeliveryPerson("张三");
        deliveryDetail.setReceiverName("董");
        deliveryDetail.setReceiverPhone("17602123195");
        deliveryDetail.setReceiverAddressDetail("上海市闵行区高兴路666弄8号");
        deliveryDetail.setDeliveryPhone("13952589089");
        deliveryDetail.setDeliveryChannelName("物流公司");
        deliveryDetail.setReceiverAddress("江苏省扬州市");
        response.setDeliveryDetail(deliveryDetail);
        return response;
    }

    @Override
    public Boolean deleteOrder(Integer orderId, String operator) {
        return true;
    }

    @Override
    public Boolean confirmReceipt(Integer orderId) {
        return true;
    }


    private OrderListItemResponse mock(Integer orderId, Integer orderStatus) {
        OrderListItemResponse response = new OrderListItemResponse();
        response.setOrderId(orderId);
        response.setSupplierName("郑州彩印有限公司");
        response.setSupplierPhone("13952589089");
        response.setPayAmount(BigDecimal.valueOf(12,2));
        response.setCreateTime(new Date());
        response.setOrderStatus(orderStatus);
        return response;
    }
}
