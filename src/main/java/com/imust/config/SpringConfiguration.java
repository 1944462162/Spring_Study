package com.imust.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Author: wangJianBo
 * Date: 2020/1/28 16:44
 * Content:
 */

/**
 * Configuration
 *      作用：指定当前的类是一个配置类
 *      细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，盖注解可以不写
 *
 * ComponentScan
 *      作用：用于通过注解指定Spring在创建容器时要扫描的包
 *
 * Bean
 *      作用：用于把当前方法的返回值作为bean对象存入Spring的IOC容器中
 *      属性：
 *          nam：用于bean的id。当不写的时候，默认值是当前方法的名称
 *      细节：
 *          查找的方式和Autowired注解的作用是一样的
 * Import
 *      作用：用于导入其他的配置类
 *      属性：
 *      value：用于指定其他配置类的字节码
 *              当我们使用Import的注解之后，有Import注解的类就是父配置类，而导入的都是子配置类
 */
@Configuration
@ComponentScan("com.imust")
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.user}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean("runner")
    public QueryRunner creatQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }


    @Bean("dataSource")
    public DataSource creatDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

    }
}
