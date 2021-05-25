package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.mapper.ActivityMapper;
import com.dianwoyin.price.service.ActivityService;
import com.dianwoyin.price.vo.response.PageResult;
import com.dianwoyin.price.vo.response.firstpage.ActivityItem;
import org.springframework.beans.factory.annotation.Autowired;
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
        result.add(loop("淮安华东彩印", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg001.hc360.cn%2Fy4%2FM07%2FFD%2FE3%2FwKhQiFTmuCeEfKQtAAAAAI6ZvF4311.jpg&refer=http%3A%2F%2Fimg001.hc360.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624554052&t=0972c3693cff1668c58b32d55829d00e"));
        result.add(loop("郑州盛大彩印", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg005.hc360.cn%2Fk2%2FM03%2F5D%2FD3%2FwKhQxVeJ1P2Ea_ScAAAAAB47k54749.jpg&refer=http%3A%2F%2Fimg005.hc360.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624554052&t=bd21155965d08e7c7ee57b76eed5cc8b"));
        result.add(loop("淮安华东彩印", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdimg.52bjw.cn%2Fimage%2Fupload%2Fcb%2F6a%2F13%2Fb3%2Fcb6a13b3fa90bdb998dbe693b3ad8846.jpg&refer=http%3A%2F%2Fdimg.52bjw.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624554052&t=cf36975d49bf888f6a9b70415e659a33"));
        result.add(loop("淮安华东彩印", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcbu01.alicdn.com%2Fimg%2Fibank%2F2018%2F690%2F830%2F9111038096_1154261209.jpg&refer=http%3A%2F%2Fcbu01.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624554052&t=b0f058605226fed7e25b65edae3a8d04"));
        result.add(loop("郑州盛大彩印", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcbu01.alicdn.com%2Fimg%2Fibank%2F2013%2F180%2F213%2F875312081_1134682458.jpg&refer=http%3A%2F%2Fcbu01.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624554052&t=e0c69ba1f63ff1a31ff9df8ff5107ced"));
        return result;
    }

    ActivityItem loop(String coName, String goodsImgUrl) {
        ActivityItem activityItem = new ActivityItem();
        activityItem.setActivityName("名片八折优惠，下单");
        activityItem.setActivityPrice(BigDecimal.valueOf(12,2));
        activityItem.setActivityImgUrl(goodsImgUrl);
        activityItem.setActivityEndTime(new Date());
        activityItem.setSupplierName(coName);
        activityItem.setSupplierAvatar("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg008.hc360.cn%2Fhb%2FMTQ2ODg2MDY5MDMwNjI1MjE2MTUyNA%3D%3D.jpg&refer=http%3A%2F%2Fimg008.hc360.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624554052&t=3192259bd48834a02170d8fca9bed403");
        activityItem.setProvince("江苏");
        activityItem.setCity("苏州");
        activityItem.setCategoryId(null);
        return activityItem;
    }
}
