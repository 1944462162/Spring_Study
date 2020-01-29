package com.imust.dao.Impl;

import com.imust.dao.IAccountDao;
import com.imust.domain.Account;
import com.imust.service.Impl.AccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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

//    @Autowired
//    private QueryRunner queryRunner;

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public void setQueryRunner(QueryRunner queryRunner) {
//        this.queryRunner = queryRunner;
//    }

    public List<Account> getAllAccount() {
        //            return queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
        return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }

    public Account findAccountById(Integer accountId) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if (accounts.isEmpty()){
            return null;
        }
        if (accounts.size() > 1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ? , money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }


}
