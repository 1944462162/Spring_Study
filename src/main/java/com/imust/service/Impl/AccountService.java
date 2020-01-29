package com.imust.service.Impl;

import com.imust.dao.IAccountDao;
import com.imust.domain.Account;
import com.imust.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/1/27 19:02
 * Content:
 */

@Service
//@Scope("prototype")
@Transactional
public class AccountService implements IAccountService {

    @Autowired
   private IAccountDao accountDao;

//    public void setAccountDao(IAccountDao accountDao) {
//        this.accountDao = accountDao;
//    }

    public List<Account> getAllAccount() {
        return accountDao.getAllAccount();
    }


    public void saveAccount() {
        accountDao.saveAccount();
    }

    public void updateAccount(int i) {
        accountDao.updateAccount(i);
    }

    public int deleteAccount() {
        accountDao.deleteAccount();
        return 0;
    }

    public void transfer(String sourceName, String targetName, Float money) {

        //根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);

        //根据名称查询转出账户
        Account target = accountDao.findAccountByName(targetName);

        //转入账户减钱
        source.setMoney(source.getMoney() - money);

        //转出账户加钱
        target.setMoney(target.getMoney() + money);

        //更新转出账户
        accountDao.updateAccount(target);

        //更新转入账户
        accountDao.updateAccount(source);
    }
}
