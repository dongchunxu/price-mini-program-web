package com.dianwoyin.price.respository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dianwoyin.price.mapper.CategoryDictMapper;
import com.dianwoyin.price.model.CategoryDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/6/7
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryDictMapper categoryDictMapper;

    public List<CategoryDict> queryAllCategory() {
        return categoryDictMapper.selectList(new QueryWrapper<CategoryDict>().ge("id", 0));
    }

    public CategoryDict queryCategroyById(Integer categoryId) {
        return categoryDictMapper.selectOne(new QueryWrapper<CategoryDict>().eq("id", categoryId));
    }
}
