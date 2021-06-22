package com.dianwoyin.price.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@Data
public class PriceListConfirmPriceRequest {

    @NotNull(message = "询价id不能为空")
    private Integer priceListId;

    @NotNull(message = "报价id不能为空")
    private Integer priceListReplyId;
}
