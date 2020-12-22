package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.MerchantService;
import com.dianwoyin.price.vo.request.MerchantCreateRequestVO;
import com.dianwoyin.price.vo.ResponseBaseVO;
import com.dianwoyin.price.vo.request.MerchantUpdateRequestVO;
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
public class MerchantController {

    @Autowired
    private MerchantService merchantService;
    

    @PostMapping("/create")
    @ApiOperation("创建商户")
    public ResponseBaseVO<Boolean> create(@Valid MerchantCreateRequestVO merchantCreateRequestVO) {
        return ResponseBaseVO.ok(merchantService.create(merchantCreateRequestVO));
    }

    @PostMapping("/update")
    @ApiOperation("更新商户")
    public ResponseBaseVO<Boolean> update(@Valid MerchantUpdateRequestVO merchantUpdateRequestVO) {
        return ResponseBaseVO.ok(merchantService.update(merchantUpdateRequestVO));
    }
}
