/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.annotations.Test;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：测试suite功能
 * 时间：2016-06-27 22:49
 * 作者：Mr.Kiwi
 */
@Test(groups = "suite")
public class TestSuite {

    @Test(groups = "suite1")
    public void testSuite1(){

        System.out.println("suite1 运行！");
    }

    @Test(groups = "suite2")
    public void testSuite2(){

        System.out.println("suite2 运行！");
    }

}
