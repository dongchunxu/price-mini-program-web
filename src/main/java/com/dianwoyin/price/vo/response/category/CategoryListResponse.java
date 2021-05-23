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
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("类目定义信息")
public class CategoryListResponse implements Serializable {
    @ApiModelProperty("类目id")
    private Integer id;

    @ApiModelProperty("类目名")
    private String categoryName;

    @ApiModelProperty("父类目id")
    private Integer parentId;

    @ApiModelProperty("图片url")
    private String imgUrl;

    @ApiModelProperty("是否是椰子节点，0：非叶子，1：叶子")
    private Boolean leaf;

    @ApiModelProperty("顺序， 默认0，数字越大优先级越高")
    private Integer seq;

    @ApiModelProperty("子类目定义信息集合")
    private List<CategoryListResponse> children;
}
