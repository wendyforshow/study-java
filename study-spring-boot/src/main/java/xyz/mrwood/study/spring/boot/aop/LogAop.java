/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import xyz.mrwood.study.spring.boot.commons.CommonConstant;
import xyz.mrwood.study.spring.boot.commons.RequestThreadLocal;
import xyz.mrwood.study.spring.boot.commons.ThreadLocalUtil;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.boot.aop
 * 功能：日志AOP，跟原生spring不一样的地方是这里要加一个@configuration
 * 时间：2016-06-21 21:18
 * 作者：Mr.Kiwi
 */
@Aspect
@Configuration
public class LogAop {

    @Pointcut("execution(* xyz.mrwood.study.spring.boot.controller..*.*(..))")
    public void getControllerPointcut() {
    }

    /**
     * 环绕增强
     *
     */
    @Around("getControllerPointcut()")
    public Object afterMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        RequestThreadLocal requestThreadLocal =
            (RequestThreadLocal) ThreadLocalUtil.get(CommonConstant.THREAD_LOCAL_REQUEST);
        requestThreadLocal.setMethodSignature(proceedingJoinPoint.getSignature().toLongString());

        // 运行代理方法
        Object proceed = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());

        requestThreadLocal.setReturnVal(proceed);

        return proceed;
    }
}
