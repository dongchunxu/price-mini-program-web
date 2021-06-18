package com.dianwoyin.price.controller;

import com.dianwoyin.price.service.PriceListService;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.BizPageResponse;
import com.dianwoyin.price.vo.request.PriceListConfirmPriceRequest;
import com.dianwoyin.price.vo.request.PriceListCreateRequest;
import com.dianwoyin.price.vo.response.price.PriceListDetailResponse;
import com.dianwoyin.price.vo.response.price.PriceListListItemResponse;
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
        Integer userId = 12345678;
        return BizBaseResponse.success(priceListService.createPriceList(request, userId));
    }

    @ApiOperation("报价单列表")
    @GetMapping("/get-price-list-list")
    public BizPageResponse<PriceListListItemResponse> getPriceListList(@ApiParam("报价单状态, 1进行中，2已完成，3已终止") @RequestParam(required = false) Integer priceListStatus
            ,@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) {
        Integer userId = 12345678;
        return BizPageResponse.success(priceListService.getPriceListList(userId, priceListStatus, page, pageSize));
    }

    @ApiOperation("采纳报价")
    @PostMapping("/confirm-price")
    public BizBaseResponse<Boolean> confirmPrice(@Valid @RequestBody PriceListConfirmPriceRequest confirmRequest) {
        Integer priceListId = null;
        Integer priceListReplyId = null;
        String operator = null;
        return BizBaseResponse.success(priceListService.confirmPrice(priceListId, priceListReplyId, operator));
    }

    @ApiOperation("报价单详情")
    @GetMapping("/get-price-list-detail/{priceListId}")
    public BizBaseResponse<PriceListDetailResponse> getPriceListDetail(@ApiParam("报价单id") @PathVariable Integer priceListId) {
        return BizBaseResponse.success(priceListService.getPriceListDetail(priceListId));
    }
}
