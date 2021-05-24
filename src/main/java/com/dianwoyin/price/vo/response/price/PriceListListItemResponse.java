package com.dianwoyin.price.vo.response.price;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Getter
@ApiModel("报价单列表item")
public class PriceListListItemResponse implements Serializable {
    @ApiModelProperty("报价单id")
    private Integer priceListId;

    @ApiModelProperty("报价单状态,1:进行中,2:已完成,3:已终止")
    private Integer priceListStatus;

    @ApiModelProperty("商品名")
    private String goodsName;

    @ApiModelProperty("商品图片")
    private String goodsImgUrl;

    @ApiModelProperty("支付金额")
    private BigDecimal payAmount;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;

    @ApiModelProperty("供应商头像集合")
    private List<String> supplierAvatars;
}
