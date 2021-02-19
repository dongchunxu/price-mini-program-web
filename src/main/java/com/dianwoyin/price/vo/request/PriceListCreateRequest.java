package com.dianwoyin.price.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Map;

/**
 * @author chunxu.dong
 * @date 2021/2/19
 */
@Data
public class PriceListCreateRequest implements Serializable {
    private Map<Integer, String> propValueMap;
}
