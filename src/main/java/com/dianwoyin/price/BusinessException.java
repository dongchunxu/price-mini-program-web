package com.dianwoyin.price;

import com.dianwoyin.price.constants.enums.ErrorCodeEnum;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public class BusinessException extends RuntimeException{
    private int code;

    private String message;

    public BusinessException(ErrorCodeEnum codeConstants) {
        this.code = codeConstants.getCode();
        this.message = codeConstants.getMessage();
    }

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message, int code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public BusinessException(String message, Throwable cause, int code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public BusinessException(Throwable cause, int code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
