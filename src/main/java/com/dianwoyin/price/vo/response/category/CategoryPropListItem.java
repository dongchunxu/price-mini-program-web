package com.dianwoyin.price.vo.response.category;

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
 * @date 2021/5/24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("属性返回对象")
public class CategoryPropListItem implements Serializable {
    @ApiModelProperty("属性id")
    private Integer id;

    @ApiModelProperty("属性名")
    private String propertyName;

    @ApiModelProperty("类目id")
    private Integer categoryId;

    @ApiModelProperty("控件类型: 0：输入框，1：下拉框，2：复选框, 3单选按钮，4text")
    private Integer inputType;

    @ApiModelProperty("是否必填，true必填")
    private Boolean must;

    @ApiModelProperty("排序用")
    private Integer seq;

    @ApiModelProperty("属性值集合")
    private List<CategoryPropValueResponse> propValues;
}
