package com.imust.web;

import com.imust.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: wangJianBo
 * Date: 2020/1/27 19:03
 * Content:
 */
public class Client {
    public static void main(String[] args) {

       // ====================== 基于XML的IOC ================================
        /**
         * ApplicationContext 的三个实现类：
         * ClassPathXmlApplicationContext 类路径下的配置文件
         * AnnotationConfigApplicationContext 注解下的配置文件
         * FileSystemXmlApplicationContext 系统磁盘下的配置文件
         *
         *
         * ApplicationContext 的作用：
         * 获取spring的IOC容器，并根据id获取对象
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
         * bean的作用范围：
         *   bean标签的scope属性：
         *      作用： 用于指定bean的作用范围
         *      取值： 常用的是单例还有多例的
         *          singleton: 单例的（默认值）
         *          prototype: 多例的
         *          request: 作用于web应用的请求范围
         *          session： 作用于web应用的会话范围
         *          global-session: 作用于集群环境的会话范围（全局会话范围），当不是集群环境的时候就是session
         */

        /**
         * Bean的生命周期：
         * 单例对象
         *      出生：当创建时对象出生
         *      活着：只要容器还在，对象就一直活着
         *      死亡：容器销毁对象死亡
         *      总结：单利对象的生命周期和容器相同
         * 多例对象
         *      出生：当我们使用对象的时候Spring为我们创建
         *      活着：对象只要在使用过程中就一直活着
         *      死亡：对象长期不使用，并且别的对象没有引用的时候，由Java回收器回收
         */

        /**
         * Spring的三种依赖注入:
         *      一、构造函数的注入：
         *      <constructor-arg name="name" value="张三"/>
         *      标签中的属性（常用）
         *          value：用于提供基本类型和String类型
         *          ref  ：用于提供其他Bean类型。指的是Spring 的IOC容器中出现的bean对象
         *      优势：
         *          在获取bean对象的时候，注入数据是必须的操作，否则对象没有办法创建成功
         *      弊端：
         *          改变了Bean的实例化的方式，使我们在创建对象的时候，如果用不到这些的数据，也必须提供
         *
         *     二、使用set方法注入
         *      <property name="name" value="张三"/>
         *      标签属性
         *          name：用于指定注入时所调用的set方法名称
         *          value：用于提供基本数据类型和引用数据类型
         *          ref：用于指定其他的bean数据类型
         *
         *     三、集合的方式注入
         *     <property name="myList">
         *             <list>
         *                 <value>AAA</value>
         *                 <value>BBB</value>
         *                 <value>CCC</value>
         *             </list>
         *      </property>
         *      用于List集合的注入标签：
         *      list（常用）
         *      用于Map机构的方式注入：
         *      Map（常用）
         */

        // ====================== 基于注解的IOC ================================

        /**
         *  用于创建的@Component注解（用于自动装配Bean）
         *  他的作用和XML中的bean的作用是一样的
         *      @Component：
         *          作用：用于把当前类对象存入Spring容器中
         *          属性：
         *              value：用于指定bean的id，当我们不写的时候默认为当前类的名字且首字母小写
         *      @Service : 一般用于业务层
         *      @Controller ： 一般用于表现层
         *      @Repository ：一般用于持久层
         */

        /**
         * 用于注入数据的
         *      他们的作用和<property></property>标签的作用是一致的
         *      @Autowired:
         *          作用：自动按照数据类型进行注入。首先会按照数据类型进行注入IAccountDao，当发现有唯一的数据类型的时候就会进行注入，如果发现数据类型并不唯一的情况下（例如继承的接口类型一致的两个类）
         *              将会按照在相同的数据类型下的类的名字进行注入accountDao，如果没有发现相同的名字将会注入失败
         *      @Resource(name = "accountDao")
         *          作用：直接按照bean的id注入。他可以独立的使用
         *          属性：
         *              name：用于指定bean的id；
         *      以上两个注解都只能注入其他的bean类型的数据，而基本类型和String类型没有办法使用上述注解实现集合类型只能使用xml类型实现
         *
         *      value
         *          作用：用于注入基本的数据类型和String数据类型
         *
         */

        /**
         *
         *用于改变作用范围
         *      scope
         *        作用：指定bean的作用范围
         *        属性：
         *             value：指定范围的取值。常用的取值：singleton prototype
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IAccountService account = applicationContext.getBean("accountService", IAccountService.class);
        account.getAllAccount();
    }
}
