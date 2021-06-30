package com.dianwoyin.price.controller;

import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.dto.MerchantDTO;
import com.dianwoyin.price.dto.UserLogin;
import com.dianwoyin.price.service.AccountService;
import com.dianwoyin.price.service.MerchantService;
import com.dianwoyin.price.utils.JwtUtils;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.request.MerchantCreateRequest;
import com.dianwoyin.price.vo.request.MerchantUpdateRequest;
import com.sun.rmi.rmid.ExecOptionPermission;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
@RestController
@RequestMapping("/api/merchant")
@Api(tags = "商户")
@Slf4j
public class MerchantController {

    @Autowired
    private MerchantService merchantService;
    @Autowired
    private JwtUtils jwtUtils;

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
    @ApiOperation("商户详情")
    public BizBaseResponse<MerchantDTO> detail(@CookieValue("Authorization") String authorization) {
        try {
            Claims claims = jwtUtils.parseJwt(authorization);
            String accountId = claims.getId();
            if(StringUtils.isEmpty(accountId)) {
                return BizBaseResponse.fail(ErrorCodeEnum.INVALID_SESSION);
            }
            return BizBaseResponse.success(merchantService.getMerchantByAccountId(accountId));
        } catch (Exception e) {
            log.error("detail 错误", e);
            return BizBaseResponse.fail(ErrorCodeEnum.ERROR_COMMON_5XX);
        }
    }
}
