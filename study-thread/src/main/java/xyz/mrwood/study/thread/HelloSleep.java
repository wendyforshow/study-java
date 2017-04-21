/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.thread;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.thread
 * 功能：
 * 时间：2016-12-08 14:45
 * 作者：Mr.Kiwi
 */
public class HelloSleep {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {


            String str = "";
            for (int j = 0; j <= i; j++) {

                str += ">";
            }

            System.out.println(str);

            Thread.sleep(2000L);
        }

    }

}
