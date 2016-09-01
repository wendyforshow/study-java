/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.hessian.server;

import xyz.mrwood.study.hessian.facade.IHelloHessian;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.hessian.server
 * 功能：
 * 时间：2016-09-01 2:13
 * 作者：Mr.Kiwi
 */
public class HelloHessian implements IHelloHessian {

    @Override
    public String hello(String name) {

        return "Hello " + name;
    }
}
