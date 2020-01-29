package com.imust.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Author: wangJianBo
 * Date: 2020/1/29 17:48
 * Content:
 */
//事务管理器
public class TranesactionConfig {

    /**
     * 创建事务管理器对象
     * @param dataSource
     * @return
     */

    /**
     * Spring 事务控制中基于注解事务控制的步骤（简单）
     *
     *      1.配置事务管理器
     *      2.开启Spring对注解事务的支持（配置在Spring的配置类上）
     *          @EnableTransactionManagement
     *      3.需要事务支持的地方使用
     *          @Transactional
     *
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager createDataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
