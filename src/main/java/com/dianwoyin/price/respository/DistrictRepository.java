package com.dianwoyin.price.respository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dianwoyin.price.mapper.DistrictDictMapper;
import com.dianwoyin.price.model.DistrictDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/6/7
 */
@Repository
public class DistrictRepository {

    @Autowired
    private DistrictDictMapper districtDictMapper;

    public List<DistrictDict> selectByParent(Integer parentId) {
        QueryWrapper<DistrictDict> queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id", parentId)
                .eq("deleted", 0);
        List<DistrictDict> districtDicts = districtDictMapper.selectList(queryWrapper);

        if (CollectionUtils.isEmpty(districtDicts)) {
            return Collections.emptyList();
        }
        return districtDicts;
    }

    public List<DistrictDict> selectByLevel(Integer level) {
        QueryWrapper<DistrictDict> queryWrapper = new QueryWrapper();
        queryWrapper.eq("level", level)
                .eq("deleted", 0);
        List<DistrictDict> districtDicts = districtDictMapper.selectList(queryWrapper);

        if (CollectionUtils.isEmpty(districtDicts)) {
            return Collections.emptyList();
        }
        return districtDicts;
    }

    public void addDistrict(DistrictDict districtDict) {
        districtDictMapper.insert(districtDict);
    }
}
