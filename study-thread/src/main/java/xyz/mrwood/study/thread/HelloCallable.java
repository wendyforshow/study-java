/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.thread;

import java.util.concurrent.*;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.thread
 * 功能：
 * 时间：2016-12-11 22:35
 * 作者：Mr.Kiwi
 */
public class HelloCallable implements Callable{


    @Override
    public Object call() throws Exception {

        String name = Thread.currentThread().getName();
        System.out.println(name);

        return name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newCachedThreadPool();

        Future submit = pool.submit(new HelloCallable());
        System.out.println(submit.get());

    }
}
