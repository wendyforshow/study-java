/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.annotations.Test;

import java.util.List;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：测试foreach为空时
 * 时间：2016-06-28 17:15
 * 作者：Mr.Kiwi
 */
public class TestForeach {

    @Test(expectedExceptions = NullPointerException.class)
    public void testForeashNPE(){

        List<String> list = null;
        for (String s : list) {

        }
    }

}
