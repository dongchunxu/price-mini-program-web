package com.dianwoyin.price.service;

import com.dianwoyin.price.vo.request.OrderCreateRequest;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.order.OrderDetailResponse;
import com.dianwoyin.price.vo.response.order.OrderListItemResponse;

/**
 * @author chunxu.dong
 * @date 2021/5/25
 */
public interface SuperOrderService {

    /**
     * @param userId
     * @param orderStatus
     * @param page
     * @param pageSize
     * @return
     */
    PageResult<OrderListItemResponse> getOrderList(Integer userId, Integer orderStatus, Integer page, Integer pageSize);

    /**
     * @param orderId
     * @return
     */
    OrderDetailResponse getOrderDetail(Integer orderId, Integer operator);


    /**
     * 删除订单
     * @param orderId
     * @param operator
     * @return
     */
    Boolean deleteOrder(Integer orderId, Integer operator);


    /**
     * 确认收货
     * @param orderId
     * @return
     */
    Boolean confirmReceipt(Integer orderId, Integer operator);

    /**
     * 创建订单
     * @param request
     * @return
     */
    Boolean createOrder(OrderCreateRequest request, Integer operator);
}
