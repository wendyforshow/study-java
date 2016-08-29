/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-08-28 23:51
 * 作者：Mr.Kiwi
 */
public class TestLog {

    private final static Logger logger = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) {

        logger.info("test info = {}", "info 信息!");
    }

}
