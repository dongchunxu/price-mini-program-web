package com.dianwoyin.price.service;

import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.firstpage.ActivityItem;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
public interface ActivityService {

    PageResult<ActivityItem> getRecommendActivity(Integer cityId, Integer categoryId, Integer page, Integer pageSize);
}
