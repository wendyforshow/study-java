/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.boot.mybatis;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.boot.mybatis
 * 功能：druid访问监控servlet
 * 时间：2016-06-28 14:35
 * 作者：Mr.Kiwi
 */
/*@WebServlet(urlPatterns = "/druid*//*",
    initParams={
        @WebInitParam(name="allow",value="192.168.16.110,127.0.0.1"),// IP白名单 (没有配置或者为空，则允许所有访问)
        @WebInitParam(name="deny",value="127.0.0.2"),// IP黑名单 (存在共同时，deny优先于allow)
        @WebInitParam(name="loginUsername",value="kiwi"),// 用户名
        @WebInitParam(name="loginPassword",value="kiwi"),// 密码
        @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
    })
public class DruidViewServlet extends StatViewServlet {
}*/
