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

    /**
     * 通过ID寻找账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 通过名字寻找账户
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
