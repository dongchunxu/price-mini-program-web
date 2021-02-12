package com.dianwoyin.price.constants.enums;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public enum DistrictLevelEnum {
    Country(1),
    Province(2),
    City(3),
    District(4),
    Street(5)
    ;

    private int level;

    DistrictLevelEnum(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
