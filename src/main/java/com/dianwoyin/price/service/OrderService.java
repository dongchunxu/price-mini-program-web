package com.dianwoyin.price.service;

import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.order.OrderDetailResponse;
import com.dianwoyin.price.vo.response.order.OrderListItemResponse;

/**
 * @author chunxu.dong
 * @date 2021/5/25
 */
public interface OrderService {

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
    OrderDetailResponse getOrderDetail(Integer orderId);
}
