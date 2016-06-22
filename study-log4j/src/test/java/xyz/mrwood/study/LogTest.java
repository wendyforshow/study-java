/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.apache.log4j.*;
import org.junit.Test;
import xyz.mrwood.study.log4j.LogApp;

import java.io.IOException;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-05-29 14:39
 * 作者：Mr.Kiwi
 */
public class LogTest {

    @Test
    public void testActivityPath() throws IOException {

        Logger myTest = Logger.getLogger("myTest");

        Layout layout = new PatternLayout("%d %p [%c] - %m%n");

        String logFilePath = "f://logs/test.log";
        Appender appender = new FileAppender(layout, logFilePath);

        myTest.addAppender(appender);


        myTest.info("222222222222222222");
    }

    @Test
    public void testHello(){

        new LogApp().hello();
    }
}
