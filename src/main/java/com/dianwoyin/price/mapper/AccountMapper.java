package com.dianwoyin.price.mapper;

import com.dianwoyin.price.entity.Account;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2020/12/21
 */
public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> selectAll();

    Account selectByUsernameAndPassword(String username, String password);

    Account selectByPhone(String phone);

    Account selectByOpenId(String openId);
}