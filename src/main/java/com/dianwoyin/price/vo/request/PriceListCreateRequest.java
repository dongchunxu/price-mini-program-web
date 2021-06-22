package com.dianwoyin.price.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author chunxu.dong
 * @date 2021/2/19
 */
@Data
public class PriceListCreateRequest implements Serializable {

    @ApiModelProperty("类目id")
    private Integer categoryId;

    @ApiModelProperty("属性值map")
    private PropValueCreateRequest propValueMap;


}
