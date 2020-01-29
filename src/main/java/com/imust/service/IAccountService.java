package com.imust.service;

import com.imust.domain.Account;
import com.imust.service.Impl.AccountService;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/1/27 19:01
 * Content:
 */
public interface IAccountService {
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
     * 转账
     * @param sourceName 转成账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
