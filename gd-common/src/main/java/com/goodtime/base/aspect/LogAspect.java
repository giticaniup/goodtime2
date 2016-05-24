package com.goodtime.base.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志类
 * Created by zhongcy on 2016/5/9.
 */
@Component("logAspect")
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    public Object around(ProceedingJoinPoint point) throws Throwable {

        System.out.println("enter aop");

        String methodName = point.getSignature().getName();

        logger.info("Received request: {}. params: {}", methodName, Arrays.toString(point.getArgs()));

        long startTime = System.currentTimeMillis();

        Object result = point.proceed();

        long endTime = System.currentTimeMillis();

        logger.info("result:{} , cost:{}", result, (endTime - startTime));

        return result;
    }

}