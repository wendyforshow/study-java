/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.annotations.Test;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-07-21 16:44
 * 作者：Mr.Kiwi
 */
public class TestProperties {

    @Test
    public void testProper(){

        System.err.println(OperateProperties.readValue("/test.properties", "name"));
    }
}
