package com.dianwoyin.price.vo.response.price;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Data
@ApiModel("报价单详情-报价历史")
public class PriceListReplyDetail {
    @ApiModelProperty("供应商名称")
    private String supplierName;

    @ApiModelProperty("供应商头像url")
    private String supplierAvatar;

    @ApiModelProperty("供应商头像url")
    private BigDecimal amount;

    @ApiModelProperty("报价时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    @ApiModelProperty("交付时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date deliveryTime;

    @ApiModelProperty("备注")
    private String comment;
}
