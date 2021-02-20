package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.PriceListService;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.request.PriceListConfirmPriceRequest;
import com.dianwoyin.price.vo.request.PriceListCreateRequest;
import com.dianwoyin.price.vo.response.PriceListDetailResponse;
import com.dianwoyin.price.vo.response.PriceListListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author chunxu.dong
 * @date 2021/2/19
 */
@RestController
@RequestMapping("/api/price-list/")
@Api(tags = "报价单")
public class PriceListController {

    @Autowired
    private PriceListService priceListService;

    @ApiOperation("创建报价单")
    @PostMapping("/create")
    public BizBaseResponse<Boolean> createPriceList(@Valid @RequestBody PriceListCreateRequest request) {
        return BizBaseResponse.ok(priceListService.createPriceList(request));
    }

    @ApiOperation("报价单列表")
    @GetMapping("/get-price-list-list")
    public BizBaseResponse<PriceListListResponse> getPriceListList(@ApiParam("报价单状态") @RequestParam(required = false) Integer priceListStatus) {
        return BizBaseResponse.ok(null);
    }

    @ApiOperation("采纳报价")
    @PostMapping("/confirm-price")
    public BizBaseResponse<Boolean> confirmPrice(@Valid @RequestBody PriceListConfirmPriceRequest confirmRequest) {
        return BizBaseResponse.ok(null);
    }

    @ApiOperation("报价单详情")
    @GetMapping("/get-price-list-detail/{priceListId}")
    public BizBaseResponse<PriceListDetailResponse> getPriceListDetail(@ApiParam("报价单id") Integer priceListId) {
        return BizBaseResponse.ok(null);
    }
}
