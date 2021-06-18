package com.dianwoyin.price.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author chunxu.dong
 * @date 2021/6/3
 */
@Data
@Builder
public class LocationDTO {

    private String province;

    private String city;

    private String district;

    private String street;
}
