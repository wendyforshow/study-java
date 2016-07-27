/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.annotations.Test;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：测试时间相关
 * 时间：2016-07-25 14:19
 * 作者：Mr.Kiwi
 */
public class TestDate {

    @Test
    public void testTime(){

        System.err.println(System.currentTimeMillis());
        System.err.println((System.currentTimeMillis()+"").length());
    }

}
