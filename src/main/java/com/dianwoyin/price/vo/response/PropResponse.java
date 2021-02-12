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

    @ApiModelProperty("控件类型: 0：下拉，1：输入，2：单选，3：多选")
    private Integer inputType;

    @ApiModelProperty("是否必填，0:必填，1：非必填")
    private Boolean must;

    @ApiModelProperty("顺序， 默认0，数字越大优先级越高")
    private Integer seq;

    @ApiModelProperty("属性值集合")
    private List<PropValueResponse> propertyValueResponseList;
}
