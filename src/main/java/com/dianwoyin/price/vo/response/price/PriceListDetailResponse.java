package com.dianwoyin.price.vo.response.price;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("报价单详情")
public class PriceListDetailResponse implements Serializable {

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

    @ApiModelProperty("产品详情")
    private GoodsDetail goodsDetail;

    @ApiModelProperty("送货详情")
    private DeliveryDetail deliveryDetail;

    @ApiModelProperty("订单详情")
    private OrderDetail orderDetail;

    @ApiModelProperty("报价历史")
    private List<PriceListReplyDetail> priceListReplyList;

}
