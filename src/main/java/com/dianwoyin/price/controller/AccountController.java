package com.dianwoyin.price.controller;

import com.dianwoyin.price.service.AccountService;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.dto.UserLogin;
import com.dianwoyin.price.helper.AccountLoginHelper;
import com.dianwoyin.price.utils.JwtUtils;
import com.dianwoyin.price.vo.BizBaseResponse;
import com.dianwoyin.price.vo.request.AccountRegisterRequest;
import com.dianwoyin.price.vo.request.AccountUpdateRequest;
import com.dianwoyin.price.vo.request.LoginPhoneRequest;
import com.dianwoyin.price.vo.request.UnionWxLoginRequest;
import com.dianwoyin.price.vo.response.acount.AccountResponse;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
@RequestMapping("/api/account")
@RestController
@Api(tags = "账户服务")
@Slf4j
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtUtils jwtUtils;


    @ApiOperation("手机号登录")
    @PostMapping("/login-by-phone")
    public BizBaseResponse<Boolean> loginByPhone(@Valid LoginPhoneRequest request, HttpServletResponse httpServletResponse) {
        try {
            String token = accountService.loginByPhone(request.getPhone(), request.getSmsCode());
            Cookie cookie = new Cookie("Authorization", token);
            httpServletResponse.addCookie(cookie);

            return BizBaseResponse.success(true);
        } catch (Exception e) {
            log.error("手机号登录失败", e);
            return BizBaseResponse.fail(ErrorCodeEnum.ERROR_COMMON_5XX);
        }
    }

//    @ApiOperation("账户密码登录")
//    @PostMapping("/login-by-password")
//    public BizBaseResponse<Boolean> loginByPassword(@RequestParam("username") String username, @RequestParam("password") String password) {
//        return BizBaseResponse.success(accountService.loginByPassword(username, password));
//    }

    @ApiOperation("微信号登录")
    @PostMapping("/login-union-by-wx")
    public BizBaseResponse<Boolean> loginUnionByWx(@Valid UnionWxLoginRequest request) {
        return BizBaseResponse.success(accountService.loginByWxUnion(request.getWxCode()));
    }

    @ApiOperation("注销")
    @PostMapping("/logout")
    public BizBaseResponse<Boolean> logout(@CookieValue("Authorization") String authorization) {
        log.info("注销登录, {}", authorization);
        // TODO
        return BizBaseResponse.success(true);
    }

//    @ApiOperation("更新账户信息")
//    @PostMapping("/update-account")
//    public BizBaseResponse<Boolean> updateAccountInfo(@Validated AccountUpdateRequest accountUpdateRequest) {
//        return BizBaseResponse.success(accountService.updateAccount(accountUpdateRequest));
//    }

//    @ApiOperation("注册账号")
//    @PostMapping("/register-by-phone")
//    public BizBaseResponse<Boolean> registerByPhone(@Valid AccountRegisterRequest registerRequestVO) {
//        return BizBaseResponse.success(accountService.registerByPhone(registerRequestVO.getPhone(), registerRequestVO.getSmsCode()));
//    }

//    @ApiOperation("获取账户信息")
//    @GetMapping("/get-account-info")
//    public BizBaseResponse<AccountResponse> getAccountInfo(@CookieValue("Authorization") String authorization) {
//        if (StringUtils.isEmpty(authorization)) {
//            return BizBaseResponse.fail(ErrorCodeEnum.SESSION_OUT);
//        }
//        String token = authorization.replace("Bearer ", "");
//        Claims claims = jwtUtils.parseJwt(token);
//        String phone = claims.getId();
//        return BizBaseResponse.success(accountService.getAccountByPhone(phone));
//    }

    @ApiOperation("获取手机验证码")
    @GetMapping("/get-login-sms-code")
    public BizBaseResponse<Boolean> getLoginSmsCode(@RequestParam("phone") String phone) {
        return BizBaseResponse.success(accountService.getLoginSmsCode(phone));
    }

    @ApiOperation("上传头像")
    @PostMapping("/upload-avatar")
    public BizBaseResponse<String> uploadAvatar(@RequestParam("file") @NotNull MultipartFile file) {
        return BizBaseResponse.success(accountService.uploadAvatar(file));
    }
}
