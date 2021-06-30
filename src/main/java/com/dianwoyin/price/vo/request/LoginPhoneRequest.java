package com.dianwoyin.price.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author chunxu.dong
 * @date 2021/6/25
 */
@Data
public class LoginPhoneRequest {
    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty("手机号")
    private String phone;

    @NotBlank(message = "手机验证码不能为空")
    @ApiModelProperty("验证码")
    private String smsCode;
}
