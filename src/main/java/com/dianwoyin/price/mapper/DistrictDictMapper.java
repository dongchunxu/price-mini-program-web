package com.dianwoyin.price.mapper;

import com.dianwoyin.price.entity.DistrictDict;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface DistrictDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DistrictDict record);

    int insertSelective(DistrictDict record);

    DistrictDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DistrictDict record);

    int updateByPrimaryKey(DistrictDict record);

    List<DistrictDict> selectList();

    List<DistrictDict> selectByParentId(Integer parentId);

    List<DistrictDict> selectByLevel(Integer level);
}