package com.dianwoyin.price.utils;

import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Slf4j
public class PriceBeanUtils {

    public static <T> List<T> copyProperty(List<?> sourceList, Class<T> clazz) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return Collections.emptyList();
        }
        return sourceList.stream().map(e-> copyProperty(e, clazz)).collect(Collectors.toList());
    }

    public static <T> T copyProperty(Object source, Class<T> clazz) {
        T target = null;
        try {
            target = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException instantiationException) {
            log.error("copyProperty error");
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_5XX);
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
