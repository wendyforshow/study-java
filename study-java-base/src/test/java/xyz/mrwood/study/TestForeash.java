/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.annotations.Test;

import java.util.List;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-09-19 14:04
 * 作者：Mr.Kiwi
 */
public class TestForeash {

    /**
     * foreash不会判空
     */
    @Test(expectedExceptions = NullPointerException.class)
    public void testForeash(){

        List<String> list = null;

        for (String s : list) {

            System.err.println(s);
        }
    }

}
