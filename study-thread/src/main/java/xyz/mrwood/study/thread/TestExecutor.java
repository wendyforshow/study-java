/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.thread
 * 功能：
 * 时间：2016-12-11 22:15
 * 作者：Mr.Kiwi
 */
public class TestExecutor implements Runnable {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.execute(new TestExecutor());
        pool.execute(new TestExecutor());
        pool.execute(new TestExecutor());

    }

    @Override
    public void run() {


        System.out.println(Thread.currentThread().getName());
    }
}
