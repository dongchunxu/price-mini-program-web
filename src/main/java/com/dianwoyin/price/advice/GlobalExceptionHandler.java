package com.dianwoyin.price.advice;

import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.vo.BizBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chunxu.dong
 * @date 2020/12/21
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**-------- 通用异常处理方法 --------**/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BizBaseResponse<Void> error(Exception e) {
        log.error("GlobalExceptionHandler.error", e);

        // 业务异常
        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            return BizBaseResponse.fail(be.getCode(), be.getMessage());
        }

        // 参数验证
        else if (e instanceof BindException) {
            String msg = "";
            BindException bindException = (BindException) e;
            for (FieldError fieldErro : bindException.getBindingResult().getFieldErrors()) {
                msg = fieldErro.getDefaultMessage();
                break;
            }
            return BizBaseResponse.fail(ErrorCodeEnum.ERROR_COMMON_PARAM);
        }

        // 通用异常兜底
        return BizBaseResponse.fail(ErrorCodeEnum.ERROR_COMMON_5XX);
    }
}
