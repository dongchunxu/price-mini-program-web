package com.dianwoyin.price.api;

import com.dianwoyin.price.vo.response.DistrictListResponseVO;

import java.util.List;
import java.util.Map;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface DistrictService {
    void init();

    List<DistrictListResponseVO> getChildrenByParentId(Integer id);


    Map<String, List<DistrictListResponseVO>> getDistrictByLevel(Integer level);
}
