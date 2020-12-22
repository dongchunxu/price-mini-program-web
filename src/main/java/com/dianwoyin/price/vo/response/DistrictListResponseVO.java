package com.dianwoyin.price.vo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("城市信息")
public class DistrictListResponseVO implements Serializable {

    @ApiModelProperty("城市id")
    private Integer id;

    @ApiModelProperty("城市名称")
    private String name;

    /**
     * name对应的拼音
     * */
    @JsonIgnore
    private String pinyin;

    /**
     * 首字母
     * */
    @JsonIgnore
    private String firstLetter;
}
