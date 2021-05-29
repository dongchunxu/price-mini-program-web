package com.dianwoyin.price.service;

import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.activity.ActivityDetailResponse;
import com.dianwoyin.price.vo.response.firstpage.ActivityItem;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
public interface ActivityService {

    PageResult<ActivityItem> getRecommendActivityPage(Integer cityId, Integer categoryId, Integer page, Integer pageSize);

    ActivityDetailResponse getActivityDetail(Integer activityId);
}
