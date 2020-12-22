package com.dianwoyin.price.constants.enums;

/**
 * @author chunxu.dong
 * @date 2020/12/15
 */
public enum MerchantStatusEnum {

    AUDITING(0, "审核中"),
    OPEN(1, "营业中"),
    CLOSED(2, "关门"),
    FORBIDDEN(3, "已被禁止"),
    ;

    private int code;

    private String desc;

    MerchantStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
