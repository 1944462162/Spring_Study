package com.imust.test;

import com.imust.config.SpringConfiguration;
import com.imust.domain.Account;
import com.imust.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Author: wangJianBo
 * Date: 2020/1/28 15:44
 * Content:
 */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        IAccountService accountService = applicationContext.getBean("accountService",IAccountService.class);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        IAccountService accountService = applicationContext.getBean("accountService",IAccountService.class);
        List<Account> allAccount = accountService.getAllAccount();

        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

}
