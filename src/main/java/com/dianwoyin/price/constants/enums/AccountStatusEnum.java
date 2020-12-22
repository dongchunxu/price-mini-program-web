package com.dianwoyin.price.constants.enums;

/**
 * @author chunxu.dong
 * @date 2020/12/21
 */
public enum AccountStatusEnum {
    NORMAL(0, "正常"),
    ;

    private Integer code;

    private String message;

    AccountStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
