package com.dianwoyin.price.respository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.dianwoyin.price.mapper.PriceListAskMapper;
import com.dianwoyin.price.model.PriceListAsk;
import com.dianwoyin.price.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/6/7
 */
@Repository
public class PriceListRepository {

    @Autowired
    private PriceListAskMapper priceListAskMapper;

    public List<PriceListAsk> getPriceListAskByUserId(String userId, Date startTime, Date endTime) {

        QueryWrapper<PriceListAsk> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("created_time", DateUtils.getStartTimeOfDay(startTime, 0))
                .le("created_time", DateUtils.getEndTimeOfDay(endTime, 0))
                .eq("deleted", 0)
                .eq("user_id", userId);
        List<PriceListAsk> priceListAsks = priceListAskMapper.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(priceListAsks)) {
            return Collections.emptyList();
        }
        return priceListAsks;
    }


    public void addPriceListAsk(PriceListAsk priceListAsk) {
        priceListAskMapper.insert(priceListAsk);
    }
}
