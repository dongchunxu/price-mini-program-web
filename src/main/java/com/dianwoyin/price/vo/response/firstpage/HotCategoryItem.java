package com.dianwoyin.price.vo.response.firstpage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("热搜item")
public class HotCategoryItem implements Serializable {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("类型，1：类目（当前只支持）")
    private Integer type;
}
