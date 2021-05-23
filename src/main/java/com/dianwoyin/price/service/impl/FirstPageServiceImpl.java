package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.service.FirstPageService;
import com.dianwoyin.price.vo.response.firstpage.ActivityItem;
import com.dianwoyin.price.vo.response.firstpage.ActivityTab;
import com.dianwoyin.price.vo.response.firstpage.FirstPageResponse;
import com.dianwoyin.price.vo.response.firstpage.HotCategoryItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Service
@Slf4j
public class FirstPageServiceImpl implements FirstPageService {

    @Override
    public FirstPageResponse getFirstPage(Integer cityId) {
        FirstPageResponse firstPageResponse = FirstPageResponse.builder()
                .activityTabs(mockTab(cityId))
                .activityItems(mockActivityItem(cityId))
                .hotCategoryItems(mockCategoryItem(cityId))
                .build();
        log.info("getFirstPage,cityId:{}, result:{}", cityId, firstPageResponse);
        return firstPageResponse;
    }


    private List<ActivityTab> mockTab(Integer cityId) {
        List<ActivityTab> result = new ArrayList<>();

        ActivityTab tab = new ActivityTab();
        tab.setCategoryId(8);
        tab.setCategoryName("联单");
        result.add(tab);

        ActivityTab tab1 = new ActivityTab();
        tab1.setCategoryId(9);
        tab1.setCategoryName("单页类");
        result.add(tab1);

        ActivityTab tab2 = new ActivityTab();
        tab2.setCategoryId(10);
        tab2.setCategoryName("不干胶类");
        result.add(tab2);

        ActivityTab tab3 = new ActivityTab();
        tab3.setCategoryId(11);
        tab3.setCategoryName("名片");
        result.add(tab3);

        return result;
    }

    private List<ActivityItem> mockActivityItem(Integer cityId) {
        List<ActivityItem> result = new ArrayList<>();

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
        result.add(activityItem);
        return result;
    }

    private List<HotCategoryItem> mockCategoryItem(Integer cityId) {
        List<HotCategoryItem> result = new ArrayList<>();
        HotCategoryItem categoryItem = new HotCategoryItem();
        categoryItem.setId(12);
        categoryItem.setName("不干胶");
        categoryItem.setType(1);
        result.add(categoryItem);
        return result;
    }

}
