package com.dianwoyin.price.vo.response.order;

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
@ApiModel("订单列表")
public class OrderListResponse implements Serializable {

    @ApiModelProperty("订单子项")
    private List<OrderListItem> orderListItems;

}
