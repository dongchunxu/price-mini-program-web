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
@ApiModel("活动tab配置")
public class ActivityTabItem implements Serializable {

    @ApiModelProperty("类目id")
    private Integer categoryId;

    @ApiModelProperty("类目名称")
    private String categoryName;
}
