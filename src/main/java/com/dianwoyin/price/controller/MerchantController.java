package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.MerchantService;
import com.dianwoyin.price.vo.request.MerchantCreateRequest;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.request.MerchantUpdateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
@RestController
@RequestMapping("/api/merchant")
@Api(tags = "商户")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;
    

    @PostMapping("/create")
    @ApiOperation("创建商户")
    public BizBaseResponse<Boolean> create(@Valid MerchantCreateRequest merchantCreateRequest) {
        return BizBaseResponse.ok(merchantService.create(merchantCreateRequest));
    }

    @PostMapping("/update")
    @ApiOperation("更新商户")
    public BizBaseResponse<Boolean> update(@Valid MerchantUpdateRequest merchantUpdateRequest) {
        return BizBaseResponse.ok(merchantService.update(merchantUpdateRequest));
    }
}
