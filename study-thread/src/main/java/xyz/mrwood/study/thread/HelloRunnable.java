/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.thread;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.thread
 * 功能：
 * 时间：2016-12-08 11:39
 * 作者：Mr.Kiwi
 */
public class HelloRunnable implements Runnable {

    @Override
    public void run() {

        System.out.println("hello runnable");
    }

    public static void main(String[] args) {

        new Thread(new HelloRunnable()).start();
    }
}
