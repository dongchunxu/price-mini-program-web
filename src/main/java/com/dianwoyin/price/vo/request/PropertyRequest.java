package com.dianwoyin.price.vo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author chunxu.dong
 * @date 2020/12/29
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyRequest {

    @NotNull
    private Integer propId;

    private Integer propValueId;

    private String propValue;
}
