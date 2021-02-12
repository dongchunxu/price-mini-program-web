package com.dianwoyin.price.vo.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/29
 */
@Data
@Builder
public class AskPriceRequest {

    @NotNull
    private Integer categoryId;
    
    @Valid
    @NotNull
    private List<PropertyRequest> propertyRequestList;
}
