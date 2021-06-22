package com.dianwoyin.price.respository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.constants.enums.PriceListStatusEnum;
import com.dianwoyin.price.mapper.PriceListAskMapper;
import com.dianwoyin.price.mapper.PriceListReplyMapper;
import com.dianwoyin.price.model.PriceListAsk;
import com.dianwoyin.price.model.PriceListReply;
import com.dianwoyin.price.utils.DateUtils;
import com.dianwoyin.price.vo.response.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.EntityWriter;
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

    @Autowired
    private PriceListReplyMapper priceListReplyMapper;


    public List<PriceListAsk> getPriceListAskByUserIdAndCreatedTime(Integer userId, Date startTime, Date endTime) {

        QueryWrapper<PriceListAsk> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("create_time", DateUtils.getStartTimeOfDay(startTime, 0))
                .le("create_time", DateUtils.getEndTimeOfDay(endTime, 0))
                .eq("deleted", 0)
                .eq("created_id", userId);
        List<PriceListAsk> priceListAsks = priceListAskMapper.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(priceListAsks)) {
            return Collections.emptyList();
        }
        return priceListAsks;
    }

    public PageResult<PriceListAsk> getPriceListAskByUserIdPage(Integer userId, Integer status, Integer page, Integer pageSize) {
        Page<Object> pageResp = PageHelper.startPage(page, pageSize);

        QueryWrapper<PriceListAsk> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("created_id", userId)
                .eq("deleted", 0)
                .orderByDesc("create_time");
        if (status != null) {
            queryWrapper.eq("status", status);
        }

        List<PriceListAsk> priceListAsks = priceListAskMapper.selectList(queryWrapper);
        return PageResult.of(priceListAsks, page, pageSize, pageResp.getTotal());
    }


    public void addPriceListAsk(PriceListAsk priceListAsk) {
        priceListAskMapper.insert(priceListAsk);
    }


    public Boolean confirmPrice(Integer priceListId, Integer priceListReplyId, Integer operator) {
        // 更新报价单状态
        updatePriceListStatus(priceListId, operator, PriceListStatusEnum.Finished);

        // 更新报价单回复
        PriceListReply priceListReply = new PriceListReply();
        priceListReply.setChosen(true);
        QueryWrapper<PriceListReply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", priceListReplyId)
                .eq("deleted", 0);
        priceListReplyMapper.update(priceListReply, queryWrapper);
        return true;
    }

    private void updatePriceListStatus(Integer priceListId, Integer operator, PriceListStatusEnum finished) {
        QueryWrapper<PriceListAsk> askQueryWrapper = new QueryWrapper<>();
        askQueryWrapper.eq("id", priceListId).eq("deleted", 0);
        PriceListAsk priceListAsk = priceListAskMapper.selectOne(askQueryWrapper);
        if (priceListAsk == null) {
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "报价单不存在");
        }
        if (!priceListAsk.getCreatedBy().equals(operator + "")) {
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "非法操作");
        }
        priceListAsk.setStatus(finished.getCode());
        priceListAskMapper.update(priceListAsk, askQueryWrapper);
    }

    public Boolean stopPrice(Integer priceListId, Integer operator) {
        updatePriceListStatus(priceListId, operator, PriceListStatusEnum.Stopped);
        return true;
    }

    public PriceListAsk getPriceListAsk(Integer priceListId) {
        QueryWrapper<PriceListAsk> askQueryWrapper = new QueryWrapper<>();
        askQueryWrapper.eq("id", priceListId).eq("deleted", 0);
        return priceListAskMapper.selectOne(askQueryWrapper);
    }
}
