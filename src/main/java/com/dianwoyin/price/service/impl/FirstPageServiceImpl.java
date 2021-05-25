package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.service.FirstPageService;
import com.dianwoyin.price.vo.response.firstpage.ActivityTabItem;
import com.dianwoyin.price.vo.response.firstpage.FirstPageResponse;
import com.dianwoyin.price.vo.response.firstpage.HotCategoryItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/5/24
 */
@Service
@Slf4j
public class FirstPageServiceImpl implements FirstPageService {

    @Override
    public FirstPageResponse getFirstPageConfig(Integer cityId) {
        FirstPageResponse firstPageResponse = FirstPageResponse.builder()
                .activityTabItems(mockTab(cityId))
                .hotCategoryItems(mockCategoryItem(cityId))
                .build();
        log.info("getFirstPage,cityId:{}, result:{}", cityId, firstPageResponse);
        return firstPageResponse;
    }


    private List<ActivityTabItem> mockTab(Integer cityId) {
        List<ActivityTabItem> result = new ArrayList<>();

        ActivityTabItem tab = new ActivityTabItem();
        tab.setCategoryId(8);
        tab.setCategoryName("联单");
        result.add(tab);

        ActivityTabItem tab1 = new ActivityTabItem();
        tab1.setCategoryId(9);
        tab1.setCategoryName("单页类");
        result.add(tab1);

        ActivityTabItem tab2 = new ActivityTabItem();
        tab2.setCategoryId(10);
        tab2.setCategoryName("不干胶类");
        result.add(tab2);

        ActivityTabItem tab3 = new ActivityTabItem();
        tab3.setCategoryId(11);
        tab3.setCategoryName("名片");
        result.add(tab3);

        return result;
    }

    private List<HotCategoryItem> mockCategoryItem(Integer cityId) {
        List<HotCategoryItem> result = new ArrayList<>();
        HotCategoryItem categoryItem = new HotCategoryItem();
        categoryItem.setId(12);
        categoryItem.setName("不干胶六折优惠");
        categoryItem.setType(1);
        result.add(categoryItem);

        HotCategoryItem categoryItem2= new HotCategoryItem();
        categoryItem2.setId(11);
        categoryItem2.setName("名片限时四折起");
        categoryItem2.setType(1);
        result.add(categoryItem2);

        HotCategoryItem categoryItem3= new HotCategoryItem();
        categoryItem3.setId(13);
        categoryItem3.setName("【年货】对联");
        categoryItem3.setType(1);
        result.add(categoryItem3);
        return result;
    }

}
