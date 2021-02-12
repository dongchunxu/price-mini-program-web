package com.dianwoyin.price.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * @author chunxu.dong
 * @date 2020/12/21
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountRegisterRequest {
    @Length(min = 11, max = 11, message = "手机号必须为11位")
    @ApiModelProperty("手机号码")
    private String phone;

    @Length(min = 4, max = 4, message = "验证码错误")
    @ApiModelProperty("验证码")
    private String smsCode;
}
