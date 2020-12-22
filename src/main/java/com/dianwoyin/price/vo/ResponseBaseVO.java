package com.dianwoyin.price.vo;

import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("通用返回封装对象")
public class ResponseBaseVO<T> {

    @ApiModelProperty("错误码, 非0直接展示下面的msg")
    private Integer code;

    @ApiModelProperty("错误信息")
    private String msg;

    @ApiModelProperty("数据")
    private T data;


    public static <T> ResponseBaseVO<T> ok(T data) {
        return new ResponseBaseVO<>(0, "success", data);
    }

    public static <T> ResponseBaseVO<T> fail(ErrorCodeEnum codeEnum) {
        return new ResponseBaseVO<T>(codeEnum.getCode(), codeEnum.getMessage(), null);
    }

    public static <T> ResponseBaseVO<T> fail(Integer code, String msg) {
        return new ResponseBaseVO<T>(code, msg, null);
    }

}
