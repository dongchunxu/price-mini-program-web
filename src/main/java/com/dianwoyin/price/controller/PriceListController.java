package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.PriceListService;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.request.PriceListCreateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
