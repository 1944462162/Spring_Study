package com.imust.web;

import com.imust.service.IAccount;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Author: wangJianBo
 * Date: 2020/1/27 19:03
 * Content:
 */
public class Client {
    public static void main(String[] args) {
        /**
         * ApplicationContext 的三个实现类：
         * ClassPathXmlApplicationContext 类路径下的配置文件
         * AnnotationConfigApplicationContext 注解下的配置文件
         * FileSystemXmlApplicationContext 系统磁盘下的配置文件
         */

        /**
         * ApplicationContext 和 BeanFactory 的区别：
         * ApplicationContext创建对象采取的策略是立即加载的方式创建，也就是说，一读取完配置文件就马上创建好配置文件中的对象了（单例设计模式）
         * BeanFactory 采用的是延迟加载的方式，也就是说什么时候根据id获取对象了，什么时候才是真正的创建对象（多例的时候使用）
         */

        /**
         * bean的三种创建方式：
         * 第一种方式：采用默认的构造函数创建
         * <bean class="com.imust.service.Impl.Account" id="account"><bean/>
         *
         * 第二种方式：使用某个类中的方法创建
         * <bean class="com.imust.service.Impl.Account" factory-bean="account" factory-method="Account"/>
         *
         * 第三种方式：使用工厂中的静态方法创建
         * <bean class="com.imust.service.Impl.Account" factory-method="Account"/>
         */

        /**
         * Bean的生命周期：
         * 单例对象
         *      出生：当创建时对象出生
         *      活着：只要容器还在，对象就一直活着
         *      死亡：容器销毁对象死亡
         *      总结：单利对象的生命周期和容器相同
         * 多例对象
         *      出生：当我们适用对象的时候Spring为我们创建
         *      活着：对象只要在使用过程中就一直活着
         *      死亡：对象长期不适用，并且别的对象没有引用的时候，由Java回收器回收
         */

        /**
         * Spring的依赖注入:
         *      构造函数的注入：
         *      <constructor-arg name="name" value="张三"/>
         *      标签中的属性（常用）
         *          value：用于提供基本类型和String类型
         *          ref  ：用于提供其他Bean类型。指的是Spring 的IOC容器中出现的bean对象
         *      优势：
         *          在获取bean对象的时候，注入数据是必须的操作，否则对象没有办法创建成功
         *      弊端：
         *          改变了Bean的实例化的方式，使我们在创建对象的时候，如果用不到这些的数据，也必须提供
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IAccount account = applicationContext.getBean("account",IAccount.class);
        System.out.println(account);
    }
}
