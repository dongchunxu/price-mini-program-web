package com.dianwoyin.price.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@ApiModel("商户更新对象")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantUpdateRequest {

    @ApiModelProperty("id")
    @NotNull
    private Integer id;

    @ApiModelProperty("商户名")
    private String merchantName;

    @ApiModelProperty("图片url")
    private String imgUrl;

    @ApiModelProperty("联系人姓名")
    private String contactName;

    @ApiModelProperty("联系号码")
    private String contactPhone;

    @ApiModelProperty("省份")
    private String province;
    
    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("区")
    private String district;

    @ApiModelProperty("街道")
    private String street;

    @ApiModelProperty("详细地址")
    private String addressDetail;

    @ApiModelProperty("规范化地址")
    private String formattedAddress;

    @ApiModelProperty("纬度")
    private String latitude;
    
    @ApiModelProperty("经度")
    private String longitude;
}
