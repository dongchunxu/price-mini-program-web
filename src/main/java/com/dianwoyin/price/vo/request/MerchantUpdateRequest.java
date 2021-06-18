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

    @ApiModelProperty("联系人姓名")
    private String receiverName;

    @ApiModelProperty("联系号码")
    private String receiverPhone;

    @ApiModelProperty("详细地址")
    private String addressDetail;

    @ApiModelProperty("纬度")
    private String latitude;
    
    @ApiModelProperty("经度")
    private String longitude;
}
