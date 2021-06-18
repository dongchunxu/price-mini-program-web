package com.dianwoyin.price.vo.response.activity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/5/30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @ApiModelProperty("生产地")
    private String supplierAddress;

    @ApiModelProperty("商品编号")
    private String goodsNo;

    @ApiModelProperty("供应商名称")
    private String supplierName;

    @ApiModelProperty("供应商头像")
    private String supplierAvatar;

    @ApiModelProperty("交付时间")
    private String deliveryTime;

    @ApiModelProperty("运费")
    private BigDecimal freightPrice;

    @ApiModelProperty("标签")
    private List<String> tags;
}
