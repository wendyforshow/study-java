/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.thread;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.thread
 * 功能：
 * 时间：2016-12-08 17:34
 * 作者：Mr.Kiwi
 */
public class HelloInterrupted implements Runnable {

    @Override
    public void run() {

        if (Thread.interrupted()){

            System.out.println("线程被中止");
            return;
        }

        for (int i = 0; i < 5; i++) {


            String str = "";
            for (int j = 0; j <= i; j++) {

                str += " >> ";
            }

            System.out.println(str);

        }

    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new HelloInterrupted());
        thread.start();

        // 关闭线程
        thread.interrupt();

    }
}
