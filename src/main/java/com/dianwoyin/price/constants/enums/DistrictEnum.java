package com.dianwoyin.price.constants.enums;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public enum DistrictEnum {

    Country(1, "国家"),
    Province(2, "省份"),
    City(3, "城市"),
    District(4, "区域"),
    Street(5, "街道")
    ;

    private int code;
    private String desc;

    DistrictEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
}
