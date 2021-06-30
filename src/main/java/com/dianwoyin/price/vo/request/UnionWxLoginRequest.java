package com.dianwoyin.price.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author chunxu.dong
 * @date 2021/6/25
 */
@Data
public class UnionWxLoginRequest {
    @NotBlank(message = "微信code不能为空")
    @ApiModelProperty("微信登录返回code")
    private String wxCode;
}
