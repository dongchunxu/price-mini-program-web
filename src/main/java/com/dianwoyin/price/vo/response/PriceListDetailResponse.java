package com.dianwoyin.price.vo.response;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("报价单列表item")
public class PriceListDetailResponse implements Serializable {

    private Integer id;

}
