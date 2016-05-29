/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.aop
 * 功能：全局日志拦截
 * 时间：2016-05-28 13:06
 * 作者：Mr.Kiwi
 */
@Aspect
@Component
public class LogAop {

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

    @Around("getServicePoint()")
    public Object aroundLoggin(ProceedingJoinPoint joinPoint) throws Throwable {

        /**
         * 打印日志格式： 类名  参数名 = 参数值 , ...
         */

        // 生成日志对象
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        // 参数值数组
        Object[] args = joinPoint.getArgs();

        // 如果有参数就打印参数日志
        if (args != null && args.length > 0) {


            // 获得方法对象，这里先通过切点对象拿到方法签名，再通过方法签名获得方法对象
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();


            // jdk1.8以前不能通过反射直接获得方法参数名列表，这里通过使用spring的api实现
            LocalVariableTableParameterNameDiscoverer u =
                new LocalVariableTableParameterNameDiscoverer();

            // 参数名称数组
            String[] parameterNames = u.getParameterNames(method);


            // 拼接参数名
            StringBuffer names = new StringBuffer();
            for (String parameterName : parameterNames) {

                names.append(parameterName + " = {}, ");
            }

            String name = names.toString();


            if (name.endsWith(", ")) {

                name = name.substring(0, name.length() - 2);
            }

            // 拼接参数值
            StringBuffer values = new StringBuffer();
            for (Object arg : args) {

                values.append(arg + " ,");
            }

            String value = values.toString();

            if (value.endsWith(" ,")) {

                value = value.substring(0, value.length() - 2);
            }

            // 打印参数日志
            logger.info(name, value);
        }

        // 运行方法，并取到返回值
        Object returnVal = null;
        if (args != null && args.length > 0) {

            returnVal = joinPoint.proceed(args);

        } else {

            returnVal = joinPoint.proceed();
        }

        // 打印返回值日志
        if (returnVal != null) {

            logger.info("returnVal = {}", returnVal);
        }

        return returnVal;

    }
}
