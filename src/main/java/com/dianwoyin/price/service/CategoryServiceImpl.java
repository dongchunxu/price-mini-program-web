package com.dianwoyin.price.service;

import com.dianwoyin.price.api.CategoryService;
import com.dianwoyin.price.vo.response.CategoryListResponseVO;
import com.dianwoyin.price.entity.CategoryDict;
import com.dianwoyin.price.mapper.CategoryDictMapper;
import com.dianwoyin.price.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunxu.dong
 * @date 2020/12/13
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDictMapper categoryDictMapper;

    @Override
    public List<CategoryListResponseVO> getAllCategoryList() {
        // 获取全量的类目信息
        List<CategoryDict> categoryDictList = categoryDictMapper.selectList();

        List<CategoryListResponseVO> categoryDictResponseList = ConvertUtils.convert(categoryDictList);
        if (CollectionUtils.isEmpty(categoryDictResponseList)) {
            return Collections.emptyList();
        }

        // 获取一级类目
        List<CategoryListResponseVO> rootCategoryResponseList
                = categoryDictResponseList.stream().filter(e->e.getParentId().equals(0)).collect(Collectors.toList());
        rootCategoryResponseList.forEach(e->findChild(categoryDictResponseList, e));

        return rootCategoryResponseList;
    }


    private void findChild(List<CategoryListResponseVO> allCategory, CategoryListResponseVO curr) {
        if (CollectionUtils.isEmpty(allCategory)) {
            return;
        }
        List<CategoryListResponseVO> childrenList = allCategory.stream()
                .filter(e -> e.getParentId().equals(curr.getId())).collect(Collectors.toList());
        curr.setChildren(childrenList);
        childrenList.forEach(e-> findChild(allCategory, e));
    }
}
