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
 * @date 2020/12/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("类目返回对象")
public class CategoryPropResponse implements Serializable {

    @ApiModelProperty("必填属性集合")
    private List<PropResponse> mustProps;

    @ApiModelProperty("可选属性集合")
    private List<PropResponse> optionalProps;
}
