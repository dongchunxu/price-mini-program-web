package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.AccountService;
import com.dianwoyin.price.vo.response.AccountResponse;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.vo.request.AccountUpdateRequest;
import com.dianwoyin.price.dto.UserLogin;
import com.dianwoyin.price.helper.AccountLoginHelper;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.request.AccountRegisterRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
@RequestMapping("/api/account")
@RestController
@Api(tags = "账户注册登录")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation("手机号登录")
    @PostMapping("/loginByPhone")
    public BizBaseResponse<Boolean> loginByPhone(@ApiParam("手机号") @RequestParam("phone") String phone,
                                                 @ApiParam("短信验证码") @RequestParam("smsCode") String smsCode) {
        return BizBaseResponse.ok(accountService.loginByPhone(phone, smsCode));
    }

    @ApiOperation("账户密码登录")
    @PostMapping("/loginByPassword")
    public BizBaseResponse<Boolean> loginByPassword(@RequestParam("username") String username, @RequestParam("password") String password) {
        return BizBaseResponse.ok(accountService.loginByPassword(username, password));
    }

    @ApiOperation("微信号登录")
    @PostMapping("/loginUnionByWx")
    public BizBaseResponse<Boolean> loginUnionByWx(@RequestParam("wxCode") String wxCode) {
        return BizBaseResponse.ok(accountService.loginByWxUnion(wxCode));
    }

    @ApiOperation("注销")
    @PostMapping("/logout")
    public BizBaseResponse<Boolean> logout() {
        UserLogin login = AccountLoginHelper.getLogin();
        if (login == null) {
            return BizBaseResponse.fail(ErrorCodeEnum.SESSION_OUT);
        }
        return BizBaseResponse.ok(accountService.logout());
    }

    @ApiOperation("更新账户信息")
    @PostMapping("/updateAccount")
    public BizBaseResponse<Boolean> updateAccountInfo(@Validated AccountUpdateRequest accountUpdateRequest) {
        return BizBaseResponse.ok(accountService.updateAccount(accountUpdateRequest));
    }

    @ApiOperation("注册账号")
    @PostMapping("/registerByPhone")
    public BizBaseResponse<Boolean> registerByPhone(@Valid AccountRegisterRequest registerRequestVO) {
        return BizBaseResponse.ok(accountService.registerByPhone(registerRequestVO.getPhone(), registerRequestVO.getSmsCode()));
    }

    @ApiOperation("获取账户信息")
    @GetMapping("/getAccountInfo")
    public BizBaseResponse<AccountResponse> getAccountInfo() {
        UserLogin login = AccountLoginHelper.getLogin();
        if (login == null) {
            return BizBaseResponse.fail(ErrorCodeEnum.INVALID_SESSION);
        }
        return BizBaseResponse.ok(accountService.getAccountByPhone(login.getPhone()));
    }

    @ApiOperation("获取手机验证码")
    @GetMapping("/getLoginSmsCode")
    public BizBaseResponse<Boolean> getLoginSmsCode(@RequestParam("phone") String phone) {
        return BizBaseResponse.ok(accountService.getLoginSmsCode(phone));
    }
}
