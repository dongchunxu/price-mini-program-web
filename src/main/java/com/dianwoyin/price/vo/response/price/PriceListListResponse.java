package com.dianwoyin.price.vo.response.price;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
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
    private List<PriceListListItemResponse> priceListItems;

}
