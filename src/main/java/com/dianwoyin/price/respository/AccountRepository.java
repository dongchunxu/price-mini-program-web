package com.dianwoyin.price.respository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dianwoyin.price.mapper.AccountMapper;
import com.dianwoyin.price.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author chunxu.dong
 * @date 2021/6/7
 */
@Repository
public class AccountRepository {

    @Autowired
    private AccountMapper accountMapper;


    public Account queryAccountByPhone(String phone) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deleted", 0)
                .eq("phone", phone);
        return accountMapper.selectOne(queryWrapper);
    }

    public Account queryAccountByOpenId(String openId) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deleted", 0)
                .eq("open_id", openId);
        return accountMapper.selectOne(queryWrapper);
    }

    public Account queryAccountByUsernameAndPassword(String username, String password) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username)
                .eq("password", password)
                .eq("deleted", 0);
        return accountMapper.selectOne(queryWrapper);
    }

    public void addAccount(Account account) {
        accountMapper.insert(account);
    }

    public void updateAccount(Account updateAccount) {
        accountMapper.updateById(updateAccount);
    }
}
