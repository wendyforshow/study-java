/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.annotations.Test;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：测试是否抛出指定异常
 * 时间：2016-06-27 22:38
 * 作者：Mr.Kiwi
 */
public class TestException {

    @Test(expectedExceptions = RuntimeException.class)
    public void testException(){

        throw new RuntimeException("这是一个RuntimeException！");
    }

}
