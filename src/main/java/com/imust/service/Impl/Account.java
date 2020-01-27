package com.imust.service.Impl;

import com.imust.service.IAccount;

import java.util.Date;

/**
 * Author: wangJianBo
 * Date: 2020/1/27 19:02
 * Content:
 */
public class Account implements IAccount {

    private String name;
    private Integer age;
    private Date brithday;

    public Account(String name, Integer age, Date brithday) {
        this.name = name;
        this.age = age;
        this.brithday = brithday;
    }

    public void Account() {

    }
}
