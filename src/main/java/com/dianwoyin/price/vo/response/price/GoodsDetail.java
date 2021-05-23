package com.dianwoyin.price.vo.response.price;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Getter
@ApiModel("报价单详情-商品详情")
public class GoodsDetail {
    @ApiModelProperty("简单属性和属性值")
    private List<SimplePropPair> propValues;

    @ApiModelProperty("备注信息")
    private String comment;
}
