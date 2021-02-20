package com.dianwoyin.price.constants.enums;

/**
 * @author chunxu.dong
 * @date 2021/2/20
 */
public enum PriceListStatusEnum {
    Going(1, "进行中"),
    Finished(2, "已完成"),
    Stopped(3, "已终止"),
    ;


    private int code;
    private String desc;

    PriceListStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
}
