package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.mapper.ActivityMapper;
import com.dianwoyin.price.service.ActivityService;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.firstpage.ActivityItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public PageResult<ActivityItem> getRecommendActivity(Integer cityId, Integer categoryId, Integer page, Integer pageSize) {
        List<ActivityItem> activityItems = mockActivityItem(cityId);
        return PageResult.of(activityItems, page, pageSize, activityItems.size());
    }


    private List<ActivityItem> mockActivityItem(Integer cityId) {
        List<ActivityItem> result = new ArrayList<>();
        result.add(loop());
        result.add(loop());
        result.add(loop());
        result.add(loop());
        result.add(loop());
        return result;
    }


    ActivityItem loop() {
        ActivityItem activityItem = new ActivityItem();
        activityItem.setActivityName("名片八折优惠，下单");
        activityItem.setActivityPrice(BigDecimal.valueOf(12,2));
        activityItem.setActivityImgUrl("");
        activityItem.setActivityEndTime(new Date());
        activityItem.setSupplierName("");
        activityItem.setSupplierAvatar("");
        activityItem.setProvince("江苏");
        activityItem.setCity("苏州");
        activityItem.setCategoryId(null);
        return activityItem;
    }
}
