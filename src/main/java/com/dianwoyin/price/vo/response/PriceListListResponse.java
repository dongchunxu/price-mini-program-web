package com.dianwoyin.price.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@ApiModel("报检单列表")
public class PriceListListResponse implements Serializable {

    @ApiModelProperty("报价单items")
    private List<PriceListListItem> priceListItems;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ApiModel("报价单列表item")
    public static class PriceListListItem implements Serializable {
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
        private Date createTime;

        @ApiModelProperty("供应商头像集合")
        private List<String> supplierAvatars;
    }

}
