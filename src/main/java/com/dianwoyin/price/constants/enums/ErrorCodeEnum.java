package com.dianwoyin.price.constants.enums;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public enum ErrorCodeEnum {

    USER_NOT_EXIST(10001, "当前用户不存在~"),
    INVALID_SESSION(10002, "当前未登录，请登录后再试~"),
    OVER_PERMISSION(10003, "非法访问"),
    UNION_LOGIN_WX_FAILED(10004, "微信登录失败,请尝试其他方式登录~"),
    ERROR_SMS_CODE (10005, "验证码错误~"),
    SESSION_OUT(10002, "当前登录已注销~"),


    ERROR_COMMON_5XX(50001, "服务器繁忙，请稍后再试~"),
    ERROR_COMMON_PARAM(50002, "请求出错~"),
    ERROR_COMMON_IMG_UPLOAD(50002, "上传图片失败~"),

    ERROR_MERCHANT_CREATE(20001, "商户创建失败, 请稍后重试~"),
    ERROR_MERCHANT_UPDATE(20001, "商户更新失败, 请稍后重试~"),

    ERROR_ASK_PRICE_CREATE(50002, "上传图片失败~"),
    ;

    private Integer code;
    private String message;

    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ErrorCodeEnum setMessage(String message) {
        this.message = message;
        return this;
    }
}
