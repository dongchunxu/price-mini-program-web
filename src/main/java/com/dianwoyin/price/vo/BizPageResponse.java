package com.dianwoyin.price.vo;

import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.vo.response.PageResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
public class BizPageResponse <T>{
    private int code;

    private String message;

    private PageResult<T> data;

    public BizPageResponse() {
        this(ErrorCodeEnum.SUCCESS, ErrorCodeEnum.SUCCESS.getDesc());
    }

    public BizPageResponse(ErrorCodeEnum errorCode) {
        this(errorCode, errorCode.getDesc());
    }

    public BizPageResponse(PageResult<T> data) {
        this(ErrorCodeEnum.SUCCESS, ErrorCodeEnum.SUCCESS.getDesc(), data);
    }

    public BizPageResponse(List<T> list, int pageNum, int pageSize, long total) {
        this(ErrorCodeEnum.SUCCESS, ErrorCodeEnum.SUCCESS.getDesc(), list, pageNum, pageSize, total);
    }

    public BizPageResponse(List<T> list, int pageNum, int pageSize, long total, int currentIndex) {
        this(ErrorCodeEnum.SUCCESS, ErrorCodeEnum.SUCCESS.getDesc(), list, pageNum, pageSize, total, currentIndex);
    }

    public BizPageResponse(ErrorCodeEnum errorCode, String message) {
        this(errorCode, message, new PageResult());
    }

    public BizPageResponse(ErrorCodeEnum errorCode, String message, PageResult<T> data) {
        this.code = errorCode.getCode();
        this.message = message;
        this.data = data;
    }

    public BizPageResponse(ErrorCodeEnum errorCode, String message, List<T> list, int pageNum, int pageSize, long total) {
        this.code = errorCode.getCode();
        this.message = message;
        this.data = PageResult.of(list, pageNum, pageSize, total);
    }

    public BizPageResponse(ErrorCodeEnum errorCode, String message, List<T> list, int pageNum, int pageSize, long total, int currentIndex) {
        this.code = errorCode.getCode();
        this.message = message;
        this.data = PageResult.of(list, pageNum, pageSize, total, currentIndex);
    }

    public static <T> BizPageResponse<T> success() {
        return new BizPageResponse();
    }

    public static <T> BizPageResponse<T> success(String message) {
        return new BizPageResponse(ErrorCodeEnum.SUCCESS, message);
    }

    public static <T> BizPageResponse<T> success(PageResult<T> data) {
        return new BizPageResponse(data);
    }

    public static <T> BizPageResponse<T> success(List<T> list, int pageNum, int pageSize, long total) {
        return new BizPageResponse(list, pageNum, pageSize, total);
    }

    public static <T> BizPageResponse<T> success(List<T> list, int pageNum, int pageSize, long total, int currentIndex) {
        return new BizPageResponse(list, pageNum, pageSize, total, currentIndex);
    }

    public static <T> BizPageResponse<T> success(String message, PageResult<T> data) {
        return new BizPageResponse(ErrorCodeEnum.SUCCESS, message, data);
    }

    public static <T> BizPageResponse<T> success(String message, List<T> list, int pageNum, int pageSize, long total) {
        return new BizPageResponse(ErrorCodeEnum.SUCCESS, message, list, pageNum, pageSize, total);
    }

    public static <T> BizPageResponse<T> success(String message, List<T> list, int pageNum, int pageSize, long total, int currentIndex) {
        return new BizPageResponse(ErrorCodeEnum.SUCCESS, message, list, pageNum, pageSize, total, currentIndex);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public PageResult<T> getData() {
        return this.data;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setData(final PageResult<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BizPageResponse(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}
