/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.provider.impl;

import xyz.mrwood.study.provider.IHelloProvider;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.provider.impl
 * 功能：
 * 时间：2016-07-20 14:54
 * 作者：Mr.Kiwi
 */
public class HelloProvider implements IHelloProvider {

    @Override
    public String hello(String name) {

        return "Hello " + name;
    }
}
