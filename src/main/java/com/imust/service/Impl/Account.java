package com.imust.service.Impl;

import com.imust.service.IAccount;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author: wangJianBo
 * Date: 2020/1/27 19:02
 * Content:
 */
public class Account implements IAccount {

    private String name;
    private Integer age;
    private Date brithday;
    private String[] myStrs;
    private List<String> myList;
    private Map<String,String> myMap;

//    public Account(String name, Integer age, Date brithday) {
//        this.name = name;
//        this.age = age;
//        this.brithday = brithday;
//    }


    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public void Account() {

    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", brithday=" + brithday +
                ", myStrs=" + Arrays.toString(myStrs) +
                ", myList=" + myList +
                ", myMap=" + myMap +
                '}';
    }
}
