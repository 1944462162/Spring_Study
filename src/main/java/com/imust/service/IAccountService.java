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
}
