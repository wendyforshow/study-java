/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：测试testng的@provide
 * 时间：2016-06-27 22:06
 * 作者：Mr.Kiwi
 */
public class TestProvider {

    /**
     * 假定区间为[1, 8]
     * 如果输入0，那么返回值是 false
     *
     * @param data
     * @param flag
     */
    @Test(dataProvider = "defaultData")
    public void testBetween(int data, boolean flag) {

        boolean b = between(data, 1, 8);
        assert b == flag;
    }

    @DataProvider
    public Object[][] defaultData() {

        return new Object[][] {

            new Object[] {0, false}, new Object[] {1, true}, new Object[] {2, true}, new Object[] {8, true}, new Object[] {9, false}};
    }

    /**
     * 判断data是否在[min, max]的区间内
     *
     * @param data
     * @param min
     * @param max
     * @return
     */
    public boolean between(int data, int min, int max) {

        return data >= min && data <= max;
    }

}
