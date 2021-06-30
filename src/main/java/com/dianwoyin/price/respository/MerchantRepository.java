package com.dianwoyin.price.respository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dianwoyin.price.mapper.MerchantMapper;
import com.dianwoyin.price.model.DistrictDict;
import com.dianwoyin.price.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/6/7
 */
@Repository
public class MerchantRepository {

    @Autowired
    private MerchantMapper merchantMapper;

    public Merchant queryMerchantByUserId(String userId) {
        QueryWrapper<Merchant> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", userId)
                .eq("deleted", 0);
        List<Merchant> merchants = merchantMapper.selectList(queryWrapper);

        if (CollectionUtils.isEmpty(merchants)) {
            return null;
        }
        return merchants.get(0);
    }

    public void addMerchant(Merchant merchant) {
        merchantMapper.insert(merchant);
    }

    public void updateMerchantGeoInfo(Merchant merchant) {
        QueryWrapper<Merchant> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", merchant.getId())
                .eq("deleted", 0);
        merchantMapper.update(merchant, queryWrapper);
    }

    public Merchant queryMerchantByAccountId(String accountId) {
        QueryWrapper<Merchant> queryWrapper = new QueryWrapper();
        queryWrapper.eq("account_id", accountId)
                .eq("deleted", 0);
        List<Merchant> merchants = merchantMapper.selectList(queryWrapper);

        if (CollectionUtils.isEmpty(merchants)) {
            return null;
        }
        return merchants.get(0);
    }
}
