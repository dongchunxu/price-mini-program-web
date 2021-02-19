package com.dianwoyin.price.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("属性返回对象")
public class PropResponse implements Serializable {
    @ApiModelProperty("属性id")
    private Integer id;

    @ApiModelProperty("属性名")
    private String propertyName;

    @ApiModelProperty("类目id")
    private Integer categoryId;

    @ApiModelProperty("控件类型: 0：输入框，1：开关按钮，2：单选框，3：复选框")
    private Integer inputType;

    @ApiModelProperty("属性值集合")
    private List<PropValueResponse> propValues;
}
