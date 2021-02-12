package com.dianwoyin.price.api;

import com.dianwoyin.price.vo.response.DistrictListResponse;

import java.util.List;
import java.util.Map;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface DistrictService {
    void init();

    List<DistrictListResponse> getChildrenByParentId(Integer id);


    Map<String, List<DistrictListResponse>> getDistrictByLevel(Integer level);
}
