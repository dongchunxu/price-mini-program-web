package com.dianwoyin.price.controller;

import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.request.OrderListRequest;
import com.dianwoyin.price.vo.response.OrderListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunxu.dong
 * @date 2021/2/19
 */
@RestController
@RequestMapping("/api/order")
@Api(tags = "订单服务")
public class OrderController {

    @ApiOperation("确认收货")
    @PostMapping("/confirm-receipt/{orderId}")
    public BizBaseResponse<Boolean> confirmReceipt(@PathVariable Integer orderId) {
        return BizBaseResponse.ok(true);
    }

    @ApiOperation("删除订单")
    @PostMapping("/delete/{orderId}")
    public BizBaseResponse<Boolean> delete(@PathVariable Integer orderId) {
        return BizBaseResponse.ok(true);
    }

    @ApiOperation("删除订单")
    @PostMapping("/get-order-list")
    public BizBaseResponse<OrderListResponse> orderList(OrderListRequest request) {
        return BizBaseResponse.ok(null);
    }


}
