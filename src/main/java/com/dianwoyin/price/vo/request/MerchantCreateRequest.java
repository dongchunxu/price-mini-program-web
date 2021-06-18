package com.dianwoyin.price.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("商户创建请求对象")
public class MerchantCreateRequest {

    @ApiModelProperty("商户名")
    @NotEmpty(message = "商户名不能为空")
    private String merchantName;

    @ApiModelProperty("姓名")
    @NotEmpty(message = "姓名不能为空")
    private String realName;

    @ApiModelProperty("邀请码")
    @NotEmpty(message = "邀请码不能为空")
    private String inviteCode;

    @ApiModelProperty("经营类型")
    @NotEmpty(message = "经营类型不能为空")
    private String businessType;

    @ApiModelProperty("收货人")
    @NotEmpty(message = "收货人不能为空")
    private String receiverName;

    @ApiModelProperty("收货人手机号码")
    @NotEmpty(message = "收货人手机号码不能为空")
    private String receiverPhone;

    @ApiModelProperty("图片url")
    @NotEmpty(message = "图片不能为空")
    private String imgUrl;

    @ApiModelProperty("纬度")
    @NotEmpty(message = "经纬度不能为空")
    private String latitude;

    @ApiModelProperty("经度")
    @NotEmpty(message = "经纬度不能为空")
    private String longitude;

    @ApiModelProperty("详细地址")
    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;
}
