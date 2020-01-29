package com.imust.test;

/**
 * Author: wangJianBo
 * Date: 2020/1/29 17:13
 * Content:
 */

import com.imust.config.SpringConfiguration;
import com.imust.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用Junit单元测试
 */

//@RunWith(SpringJUnit4ClassRunner.class)
////加载Spring的配置类
//@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountTest {



    @Test
    public void testFindAll() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        IAccountService accountService = applicationContext.getBean("accountService",IAccountService.class);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);

        accountService.transfer("aaa","bbb",100f);
    }
}