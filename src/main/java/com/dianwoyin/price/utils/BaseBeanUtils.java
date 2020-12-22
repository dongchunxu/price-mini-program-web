package com.dianwoyin.price.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public class BaseBeanUtils {

    public static <T> List<T> copyProperty(List<?> sourceList, Class<T> clazz) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return Collections.emptyList();
        }
        return sourceList.stream().map(e->{
            T target = null;
            try {
                target = clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException instantiationException) {
                instantiationException.printStackTrace();
            }
            BeanUtils.copyProperties(e, target);
            return target;
         }).collect(Collectors.toList());
    }

    public static <T> T copyProperty(Object source, Class<T> clazz) {
        T target = null;
        try {
            target = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException instantiationException) {
            instantiationException.printStackTrace();
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
