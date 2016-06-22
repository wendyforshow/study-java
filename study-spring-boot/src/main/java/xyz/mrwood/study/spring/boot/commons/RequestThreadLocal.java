/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.boot.commons;

import java.util.Map;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.log4j
 * 功能：请求线程对象，用于记录每次请求的信息
 * 时间：2016-06-20 17:15
 * 作者：Mr.Kiwi
 */
public class RequestThreadLocal {

    /**
     * 访问id
     */
    private String requestId;

    /**
     * 是否成功，1成功 0失败
     */
    private int isSuccess = 1;

    /**
     * 请求者ip
     */
    private String userIp;

    /**
     * 请求的url地址
     */
    private String requestUrl;

    /**
     * 请求参数map
     */
    private Map requestParamsMap;

    /**
     * 异常信息
     */
    private String exceptionMsg;

    /**
     * 异常详细堆栈信息
     */
    private String exceptionDetailMsg;

    /**
     * 返回值
     */
    private Object returnVal;

    /**
     * 方法签名
     */
    private String methodSignature;

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Map getRequestParamsMap() {
        return requestParamsMap;
    }

    public void setRequestParamsMap(Map requestParamsMap) {
        this.requestParamsMap = requestParamsMap;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public Object getReturnVal() {
        return returnVal;
    }

    public void setReturnVal(Object returnVal) {
        this.returnVal = returnVal;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getExceptionDetailMsg() {
        return exceptionDetailMsg;
    }

    public void setExceptionDetailMsg(String exceptionDetailMsg) {
        this.exceptionDetailMsg = exceptionDetailMsg;
    }

    @Override
    public String toString() {
        return "RequestThreadLocal{" +
            "requestId='" + requestId + '\'' +
            ", isSuccess=" + isSuccess +
            ", userIp='" + userIp + '\'' +
            ", requestUrl='" + requestUrl + '\'' +
            ", requestParamsMap=" + requestParamsMap +
            ", exceptionMsg='" + exceptionMsg + '\'' +
            ", exceptionDetailMsg='" + exceptionDetailMsg + '\'' +
            ", returnVal=" + returnVal +
            ", methodSignature='" + methodSignature + '\'' +
            '}';
    }

    public String getMethodSignature() {
        return methodSignature;
    }

    public void setMethodSignature(String methodSignature) {
        this.methodSignature = methodSignature;
    }

}
