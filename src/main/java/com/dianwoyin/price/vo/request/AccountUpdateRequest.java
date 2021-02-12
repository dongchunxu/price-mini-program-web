package com.dianwoyin.price.vo.request;

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
public class AccountUpdateRequest {

    @Length(min = 1, max = 64, message = "地址格式不正确")
    private String address;

    @NotNull(message = "经纬度错误")
    private Double latitude;

    @NotNull(message = "经纬度错误")
    private Double longitude;

    @Length(min = 1, max = 64, message = "省份信息必填")
    private String province;

    @Length(min = 1, max = 64, message = "城市信息必填")
    private String city;

    @Length(min = 1, max = 64, message = "地区信息必填")
    private String district;
}
