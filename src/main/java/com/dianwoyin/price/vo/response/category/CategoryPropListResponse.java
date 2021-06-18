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
 * @date 2020/12/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("类目返回对象")
public class CategoryPropListResponse implements Serializable {

    @ApiModelProperty("必填属性集合")
    private List<CategoryPropListItem> basicProps;

    @ApiModelProperty("其他属性集合")
    private List<CategoryPropListItem> otherProps;

}
