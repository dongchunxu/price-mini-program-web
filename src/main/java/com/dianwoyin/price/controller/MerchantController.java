package com.dianwoyin.price.controller;

import com.dianwoyin.price.dto.MerchantDTO;
import com.dianwoyin.price.dto.UserLogin;
import com.dianwoyin.price.service.MerchantService;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.request.MerchantCreateRequest;
import com.dianwoyin.price.vo.request.MerchantUpdateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public BizBaseResponse<Boolean> create(@Valid @RequestBody MerchantCreateRequest merchantCreateRequest) {
        return BizBaseResponse.success(merchantService.createMerchant(merchantCreateRequest));
    }

    @PostMapping("/update")
    @ApiOperation("更新商户")
    public BizBaseResponse<Boolean> update(@Valid @RequestBody MerchantUpdateRequest merchantUpdateRequest) {
        return BizBaseResponse.success(merchantService.updateMerchant(merchantUpdateRequest));
    }

    @GetMapping("/detail")
    @ApiOperation("更新商户")
    public BizBaseResponse<MerchantDTO> detail() {
        String userId = "xxxx";
        return BizBaseResponse.success(merchantService.getMerchant(userId));
    }
}
