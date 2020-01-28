package com.imust.dao.Impl;

import com.imust.dao.IAccountDao;
import com.imust.domain.Account;
import com.imust.service.Impl.AccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/1/28 10:47
 * Content:
 */

@Repository
public class AccountDao implements IAccountDao {

    @Autowired
    private QueryRunner queryRunner;

//    public void setQueryRunner(QueryRunner queryRunner) {
//        this.queryRunner = queryRunner;
//    }

    public List<Account> getAllAccount() {
        try {
            return queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
