package com.dianwoyin.price.controller;

import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.request.OrderCreateRequest;
import com.dianwoyin.price.vo.response.OrderDetailResponse;
import com.dianwoyin.price.vo.response.OrderListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public BizBaseResponse<Boolean> confirmReceipt(@ApiParam("订单id") @PathVariable Integer orderId) {
        return BizBaseResponse.ok(true);
    }

    @ApiOperation("删除订单")
    @PostMapping("/delete/{orderId}")
    public BizBaseResponse<Boolean> delete(@ApiParam("订单id") @PathVariable Integer orderId) {
        return BizBaseResponse.ok(true);
    }

    @ApiOperation("获取订单列表")
    @GetMapping("/get-order-list")
    public BizBaseResponse<OrderListResponse> orderList(@ApiParam("订单状态") @RequestParam(required = false) Integer orderStatus) {
        return BizBaseResponse.ok(null);
    }

    @ApiOperation("获取订单详情")
    @GetMapping("/get-order-detail/{orderId}")
    public BizBaseResponse<OrderDetailResponse> orderDetail(@ApiParam("订单id") @PathVariable Integer orderId) {
        return BizBaseResponse.ok(null);
    }

    @ApiOperation("创建订单")
    @PostMapping("/create")
    public BizBaseResponse<Boolean> create(@RequestBody @Valid OrderCreateRequest createRequest) {
        return BizBaseResponse.ok(true);
    }


}
