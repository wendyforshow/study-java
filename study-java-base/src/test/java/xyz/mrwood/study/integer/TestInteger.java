/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.integer;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.integer
 * 功能：Integer理解
 * 时间：2016-07-18 14:43
 * 作者：Mr.Kiwi
 */
public class TestInteger {

    @Test
    public void testInteger(){

        Integer one = new Integer(1);
        Integer one1 = new Integer(1);
        Integer two = new Integer(2);
        int i = 1;
        Integer o1 = Integer.valueOf(1);
        Integer o2 = Integer.valueOf(1);

        Integer oo1 = Integer.valueOf(128);
        Integer oo2 = Integer.valueOf(128);

        Assert.assertEquals(one.equals(one1), true, "两个相同数值的Integer对象用equal比较应该是相等的");
        Assert.assertEquals(one == i, true, "Integer 可以 基本类型int直接用==比较，因为自动装箱的原因");
        Assert.assertEquals(one == one1, false);
        Assert.assertEquals(one.equals(two), false);
        Assert.assertEquals(one == two, false);
        Assert.assertEquals(o1 == o2, true);

        Assert.assertEquals(oo1 == oo2, false, "java底层缓存了最大到127个Integer对象");
    }

}
