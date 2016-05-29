/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.aop
 * 功能：aop实现
 * 时间：2016-05-28 10:33
 * 作者：Mr.Kiwi
 * 通知类型：
 * 前置通知（Before advice）：在某连接点之前执行的通知，但这个通知不能阻止连接点之前的执行流程（除非它抛出一个异常）。
 * 后置通知（After returning advice）：在某连接点正常完成后执行的通知：例如，一个方法没有抛出任何异常，正常返回。
 * 异常通知（After throwing advice）：在方法抛出异常退出时执行的通知。
 * 最终通知（After (finally) advice）：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
 * 环绕通知（Around Advice）：包围一个连接点的通知，如方法调用。这是最强大的一种通知类型。环绕通知可以在方法调用前后完成自定义的行为。它也会选择是否继续执行连接点或直接返回它自己的返回值或抛出异常来结束执行。
 */
@Aspect
@Component
public class AopHandler {

    /**
     * 拦截工程下所有的切点
     */
    @Pointcut("execution(* xyz.mrwood.study..*.*(..))")
    public void getAllPoint() {
    }

    /**
     * 拦截所有service层下的切点
     */
    @Pointcut("execution(* xyz.mrwood.study.service..*.*(..))")
    public void getServicePoint() {
    }


    /**
     * 前置增强
     * @param joinPoint
     */
    @Before("getServicePoint()")
    public void beforeMethod(JoinPoint joinPoint){

        System.out.println("[前置增强开始]：" + "方法开始了");
    }

    @AfterThrowing(value = "getServicePoint()", throwing = "ex")
    public void exceptionMethod(JoinPoint joinPoint, Exception ex){

        System.out.println("[异常增强]：" + "如果你看到这行，就说明你的程序报错了！" + "异常信息：" + ex.getMessage());
    }

    /**
     * 后置增强，只有在方法正常结束才会调用
     * @param returnVal
     */
    @AfterReturning(value = "getServicePoint()",returning = "returnVal")
    public void afterReturningMethod(Object returnVal){

        System.out.println("[后置增强]：" + "当你看到这个说明，你的方法没有正常结束了！" + "它的返回值为：" + returnVal);
    }

    /**
     * 最终增强，类似于finally的功能
     */
    @After("getServicePoint()")
    public void afterMethod(){

        System.out.println("[最终增强]：" + "无论发论发生什么事，我都会运行！");
    }

    /**
     * 环绕增强
     * @param proceedingJoinPoint
     */
    @Around("getServicePoint()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("[环绕增强开始]：" + "方法开始了！");
        Object returnVal = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        System.out.println("[环绕增强结束]：" + "方法已经结束了！");

        return returnVal;
    }
}
