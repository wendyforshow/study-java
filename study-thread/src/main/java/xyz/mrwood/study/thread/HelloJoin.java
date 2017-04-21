/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.thread;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.thread
 * 功能：
 * 时间：2016-12-08 20:04
 * 作者：Mr.Kiwi
 */
public class HelloJoin implements Runnable {

    private static int a = 0;

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {

            a += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new HelloJoin());

        thread1.start();

        thread1.join();
        System.out.println(a);
    }
}
