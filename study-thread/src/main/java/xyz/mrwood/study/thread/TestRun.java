/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.thread;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.thread
 * 功能：
 * 时间：2016-12-09 10:10
 * 作者：Mr.Kiwi
 */
public class TestRun {

    public static void main(String[] args) {

        new Thread(new HelloSynchronized()).start();
        new Thread(new HelloSynchronized()).start();

    }

}
