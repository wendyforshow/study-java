/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.thread;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.thread
 * 功能：
 * 时间：2016-12-09 09:47
 * 作者：Mr.Kiwi
 */
public class HelloSynchronized implements Runnable {

    private static int i = 50;

    @Override
    public void run() {

        test();
    }

    private synchronized void test() {
            while (i > 0) {

                System.out.println(Thread.currentThread().getName() + " --> " + i--);
            }
    }

}
