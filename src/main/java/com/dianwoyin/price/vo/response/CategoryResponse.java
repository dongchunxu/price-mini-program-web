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
public class CategoryResponse implements Serializable {

    @ApiModelProperty("类目属性定义信息集合")
    private List<PropResponse> propResponseList;
}
