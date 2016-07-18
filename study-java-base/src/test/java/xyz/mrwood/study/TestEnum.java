/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.Assert;
import org.testng.annotations.Test;
import xyz.mrwood.study.enumpojo.PayTradeStatus;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-07-18 10:25
 * 作者：Mr.Kiwi
 */
public class TestEnum {

    @Test
    public void testEnum(){

        Assert.assertEquals(PayTradeStatus.TRADE_SUCCESS.toString().equals("TRADE_SUCCESS"), true);
    }

}
