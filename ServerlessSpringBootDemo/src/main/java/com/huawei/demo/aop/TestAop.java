package com.huawei.demo.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAop {
    private static Logger logger = LoggerFactory.getLogger(TestAop.class);
    private long start = 0;

    @Pointcut("execution(* com.huawei.demo.services.impl.*.**(..))")
    public void log() {
    }

    @Before("log()")
    public void before() {
        start = System.currentTimeMillis();
        logger.warn("Before function execute.");
    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.warn("Return of function: {}",  ret);
        long cost = System.currentTimeMillis() - start;
        logger.warn("cost {} ms to handle the request.", cost);
    }

    //后置异常通知
    @AfterThrowing(value="log()", throwing = "e")
    public void throwss(Throwable e){
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Exception occurred....." + e);
        System.out.println("-------------------------------------------------------------------------");
    }
}

