package com.imust.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Author: wangJianBo
 * Date: 2020/1/29 9:53
 * Content: 通知类
 */

@Component("logger")
@Aspect//表示当前类是一个切面
public class Logger {

    @Pointcut("execution(* com.imust.service.Impl.*.*(..))")
    public void pt1(){}

    @Before("pt1()")
    public void printLog(){
        System.out.println("Logger 类中的printLog方法执行了。。。。");
    }

    /**
     * 环绕通知
     */

    @Around("pt1()")
    public Object arroundPringlog(ProceedingJoinPoint proceedingJoinPoint){

        Object[] args = proceedingJoinPoint.getArgs();
        try {
            System.out.println("logger类中的arroundPringlog方法开始记录日志了...前置");
            Object proceed = proceedingJoinPoint.proceed(args);
            System.out.println("logger类中的arroundPringlog方法开始记录日志了...后置");
            return proceed;
        } catch (Throwable throwable) {
            System.out.println("logger类中的arroundPringlog方法开始记录日志了...异常");
            throw new RuntimeException(throwable);
        }
        finally {
            System.out.println("logger类中的arroundPringlog方法开始记录日志了...最终");
        }

    }
}
