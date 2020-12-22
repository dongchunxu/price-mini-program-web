package com.dianwoyin.price.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author chunxu.dong
 * @date 2020/12/15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateDTO {

    @Length(min = 1, max = 64)
    private String address;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longtitude;

    @Length(min = 1, max = 64)
    private String province;

    @Length(min = 1, max = 64)
    private String city;

    @Length(min = 1, max = 64)
    private String district;
}
