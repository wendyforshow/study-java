/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.boot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.WebUtils;
import xyz.mrwood.study.spring.boot.commons.CommonConstant;
import xyz.mrwood.study.spring.boot.commons.RequestThreadLocal;
import xyz.mrwood.study.spring.boot.commons.ThreadLocalUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.boot.web
 * 功能：Request请求的监听器，主要用于生成接口监听日志
 * 时间：2016-06-21 15:59
 * 作者：Mr.Kiwi
 */
public class RequestListener implements ServletRequestListener {

    private static Logger logger = LoggerFactory.getLogger("monitor");

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        System.err.println("销毁request");
        logger.info("requestInfo = {}", ThreadLocalUtil.get(CommonConstant.THREAD_LOCAL_REQUEST));

        ThreadLocalUtil.remove();
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

        System.err.println("初始化request");

        HttpServletRequest request = (HttpServletRequest)servletRequestEvent.getServletRequest();


        RequestThreadLocal requestThreadLocal = new RequestThreadLocal();
        requestThreadLocal.setRequestParamsMap(WebUtils.getParametersStartingWith(request, ""));
        requestThreadLocal.setUserIp(request.getRemoteAddr());
        requestThreadLocal.setRequestUrl(request.getRequestURL().toString());
        String requestId = UUID.randomUUID().toString();
        requestThreadLocal.setRequestId(requestId);

        ThreadLocalUtil.put(CommonConstant.THREAD_LOCAL_REQUEST, requestThreadLocal);
        ThreadLocalUtil.put(CommonConstant.THREAD_LOCAL_REQUEST_ID, requestId);
    }
}
