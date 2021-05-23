package com.dianwoyin.price.utils;

import com.dianwoyin.price.entity.CategoryDict;
import com.dianwoyin.price.vo.response.category.CategoryListResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public class ConvertUtils {

    public static List<CategoryListResponse> convert(List<CategoryDict> sourceList) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return Collections.emptyList();
        }

        return sourceList.stream().map(e->{
            CategoryListResponse target = new CategoryListResponse();
            BeanUtils.copyProperties(e, target);
            return target;
        }).collect(Collectors.toList());
    }
}
