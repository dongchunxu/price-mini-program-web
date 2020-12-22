package com.dianwoyin.price.constants.enums;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public enum DistrictLevelEnum {
    COUNTRY(1),
    PROVINCE(2),
    CITY(3),
    DISTRICT(4),
    STREET(5)
    ;

    private int level;

    DistrictLevelEnum(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
