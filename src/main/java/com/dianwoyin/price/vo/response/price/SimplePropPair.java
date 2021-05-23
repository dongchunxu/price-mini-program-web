package com.dianwoyin.price.vo.response.price;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Getter
@ApiModel("报价单详情-属性/属性值")
public class SimplePropPair {

    @ApiModelProperty("属性名")
    private String propName;

    @ApiModelProperty("属性值")
    private String propValue;
}
