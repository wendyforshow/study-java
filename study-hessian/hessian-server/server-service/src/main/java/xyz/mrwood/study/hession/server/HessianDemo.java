/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.hession.server;

import xyz.mrwood.study.hession.facade.IHessianDemo;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.hession.server
 * 功能：
 * 时间：2016-09-02 2:08
 * 作者：Mr.Kiwi
 */
public class HessianDemo implements IHessianDemo {

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
