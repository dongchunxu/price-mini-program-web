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
    @NotNull(message = "商户名不能为空")
    private String merchantName;

    @ApiModelProperty("图片url")
    @NotNull(message = "图片不能为空")
    private String imgUrl;

    @ApiModelProperty("类目id")
    @NotNull(message = "类目不能为空")
    private Integer categoryId;

    @ApiModelProperty("联系人姓名")
    @NotNull(message = "联系人姓名不能为空")
    private String contactName;

    @ApiModelProperty("联系号码")
    @NotNull(message = "联系号码不能为空")
    private String contactPhone;

    @ApiModelProperty("省份")
    @NotNull(message = "省份不能为空")
    private String province;
    
    @ApiModelProperty("城市")
    @NotNull(message = "城市不能为空")
    private String city;

    @ApiModelProperty("区")
    @NotNull(message = "区不能为空")
    private String district;

    @ApiModelProperty("街道")
    @NotNull(message = "街道不能为空")
    private String street;

    @ApiModelProperty("详细地址")
    @NotNull(message = "详细地址不能为空")
    private String addressDetail;

    @ApiModelProperty("规范化地址")
    @NotNull(message = "规范化地址不能为空")
    private String formattedAddress;

    @ApiModelProperty("纬度")
    @NotNull(message = "经纬度不能为空")
    private String latitude;
    
    @ApiModelProperty("经度")
    @NotNull(message = "经纬度不能为空")
    private String longitude;
}
