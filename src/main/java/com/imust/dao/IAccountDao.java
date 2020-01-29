package com.imust.dao;

import com.imust.domain.Account;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/1/28 10:46
 * Content:
 */
public interface IAccountDao {
    List<Account> getAllAccount();

    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     */
    void updateAccount(int i);

    /**
     * 删除账户
     * @return
     */
    int deleteAccount();
}
