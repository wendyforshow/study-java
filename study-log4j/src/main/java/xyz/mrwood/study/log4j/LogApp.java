/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.log4j;

import org.apache.log4j.Logger;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.log4j
 * 功能：
 * 时间：2016-05-29 14:55
 * 作者：Mr.Kiwi
 */
public class LogApp {

    private static Logger logger = Logger.getLogger(LogApp.class);

    public void hello(){

        logger.info("这是LogApp的日志");

        System.out.println("hello world!");
    }
}
