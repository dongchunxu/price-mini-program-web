package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.constants.enums.OrderStatusEnum;
import com.dianwoyin.price.model.SuperOrder;
import com.dianwoyin.price.respository.SuperOrderRepository;
import com.dianwoyin.price.service.SuperOrderService;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.order.DeliveryDetail;
import com.dianwoyin.price.vo.response.order.OrderDetailResponse;
import com.dianwoyin.price.vo.response.order.OrderListItemResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SuperOrderServiceImpl implements SuperOrderService {


    @Autowired
    private SuperOrderRepository superOrderRepository;

    @Override
    public PageResult<OrderListItemResponse> getOrderList(Integer userId, Integer orderStatus,
                                                          Integer page, Integer pageSize) {

        PageResult<SuperOrder> pageResult = superOrderRepository.getOrderList(userId, orderStatus, page, pageSize);
        List<OrderListItemResponse> dataList = new ArrayList<>();
        dataList.add(mock("测试数据123123123123123qweqweq1，测试1", 1001, orderStatus));
        dataList.add(mock("测试数据123123123123123qweqwe1，测试1",1002, orderStatus));
        dataList.add(mock("测试数据1231231231231231qweqe，测试1",1003, orderStatus));
        dataList.add(mock("测试数据123123123123123qweqe1，测试1",1004, orderStatus));
        dataList.add(mock("测试数据123123123123123qweqwe1，测试1",1005, orderStatus));
        return PageResult.of(dataList, page, pageSize, dataList.size());
    }

    @Override
    public OrderDetailResponse getOrderDetail(Integer orderId, Integer operator) {

        SuperOrder superOrder = superOrderRepository.getOrderById(orderId, operator);
        OrderDetailResponse target = new OrderDetailResponse();

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

    private OrderListItemResponse mock(String goodsName, Integer orderId, Integer orderStatus) {
        OrderListItemResponse response = new OrderListItemResponse();
        response.setOrderId(orderId);
        response.setGoodsImgUrl("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01f8bc5ac9ac8ca801212573f14f60.jpg%402o.jpg&refer=http%3A%2F%2Fimg.zcool.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624777396&t=7686cd9fd91997e7baf8dc60b503bb16");
        response.setGoodsName(goodsName);
        response.setSupplierName("郑州彩印有限公司");
        response.setSupplierPhone("13952589089");
        response.setPayAmount(BigDecimal.valueOf(12,2));
        response.setCreateTime(new Date());
        response.setOrderStatus(orderStatus);
        return response;
    }
}
