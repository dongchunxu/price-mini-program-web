package com.dianwoyin.price.controller;

import com.dianwoyin.price.api.AccountService;
import com.dianwoyin.price.vo.response.AccountResponseVO;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.vo.request.AccountUpdateRequestVO;
import com.dianwoyin.price.dto.UserLogin;
import com.dianwoyin.price.helper.AccountLoginHelper;
import com.dianwoyin.price.vo.ResponseBaseVO;
import com.dianwoyin.price.vo.request.AccountRegisterRequestVO;
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
@Api("账户Controller")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation("手机号登录")
    @PostMapping("/loginByPhone")
    public ResponseBaseVO<Boolean> loginByPhone(@ApiParam("手机号") @RequestParam("phone") String phone,
                                                @ApiParam("短信验证码") @RequestParam("smsCode") String smsCode) {
        return ResponseBaseVO.ok(accountService.loginByPhone(phone, smsCode));
    }

    @ApiOperation("账户密码登录")
    @PostMapping("/loginByPassword")
    public ResponseBaseVO<Boolean> loginByPassword(@RequestParam("username") String username, @RequestParam("password") String password) {
        return ResponseBaseVO.ok(accountService.loginByPassword(username, password));
    }

    @ApiOperation("微信号登录")
    @PostMapping("/loginUnionByWx")
    public ResponseBaseVO<Boolean> loginUnionByWx(@RequestParam("wxCode") String wxCode) {
        return ResponseBaseVO.ok(accountService.loginUnionByWx(wxCode));
    }

    @ApiOperation("注销")
    @PostMapping("/logout")
    public ResponseBaseVO<Boolean> logout() {
        UserLogin login = AccountLoginHelper.getLogin();
        if (login == null) {
            return ResponseBaseVO.fail(ErrorCodeEnum.SESSION_OUT);
        }
        return ResponseBaseVO.ok(accountService.logout());
    }

    @ApiOperation("更新账户信息")
    @PostMapping("/updateAccount")
    public ResponseBaseVO<Boolean> updateAccountInfo(@Validated AccountUpdateRequestVO accountUpdateRequestVO) {
        return ResponseBaseVO.ok(accountService.updateAccount(accountUpdateRequestVO));
    }

    @ApiOperation("注册账号")
    @PostMapping("/registerByPhone")
    public ResponseBaseVO<Boolean> registerByPhone(@Valid AccountRegisterRequestVO registerRequestVO) {
        return ResponseBaseVO.ok(accountService.registerByPhone(registerRequestVO.getPhone(), registerRequestVO.getSmsCode()));
    }

    @ApiOperation("获取账户信息")
    @GetMapping("/getAccountInfo")
    public ResponseBaseVO<AccountResponseVO> getAccountInfo() {
        UserLogin login = AccountLoginHelper.getLogin();
        if (login == null) {
            return ResponseBaseVO.fail(ErrorCodeEnum.INVALID_SESSION);
        }
        return ResponseBaseVO.ok(accountService.getAccountByPhone(login.getPhone()));
    }

    @ApiOperation("获取手机验证码")
    @GetMapping("/getLoginSmsCode")
    public ResponseBaseVO<Boolean> getLoginSmsCode(@RequestParam("phone") String phone) {
        return ResponseBaseVO.ok(accountService.getLoginSmsCode(phone));
    }
}
