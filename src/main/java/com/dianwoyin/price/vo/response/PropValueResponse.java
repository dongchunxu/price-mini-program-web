package com.dianwoyin.price.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("属性值返回对象")
public class PropValueResponse implements Serializable {
    @ApiModelProperty("属性值id")
    private Integer id;

    @ApiModelProperty("属性id")
    private Integer propertyId;

    @ApiModelProperty("属性值名称")
    private String propertyValueName;
}
