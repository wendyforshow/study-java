/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.boot.base;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import xyz.mrwood.study.spring.boot.commons.CommonConstant;
import xyz.mrwood.study.spring.boot.commons.RequestThreadLocal;
import xyz.mrwood.study.spring.boot.commons.ThreadLocalUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.boot.controller
 * 功能：
 * 时间：2016-06-21 18:12
 * 作者：Mr.Kiwi
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public void defaultExceptionHandler(HttpServletRequest request, HttpServletResponse response,Exception ex){


        RequestThreadLocal requestThreadLocal =
            (RequestThreadLocal) ThreadLocalUtil.get(CommonConstant.THREAD_LOCAL_REQUEST);
        requestThreadLocal.setIsSuccess(0);
        requestThreadLocal.setExceptionMsg(ex.getMessage());
        requestThreadLocal.setExceptionDetailMsg(ExceptionUtils.getStackTrace(ex));

        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("result", -200);
        returnMap.put("msg", "服务器繁忙，请稍后再试！");

        try {
            response.getWriter().write(JSON.toJSONString(returnMap));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
