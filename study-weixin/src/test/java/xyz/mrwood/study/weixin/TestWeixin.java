/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.weixin;

import com.foxinmy.weixin4j.exception.WeixinException;
import com.foxinmy.weixin4j.model.WeixinPayAccount;
import com.foxinmy.weixin4j.payment.WeixinPayProxy;
import com.foxinmy.weixin4j.payment.mch.OpenIdResult;
import org.testng.annotations.Test;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.weixin
 * 功能：
 * 时间：2016-11-26 14:23
 * 作者：Mr.Kiwi
 */
public class TestWeixin {



    @Test
    public void testGetOpenapi(){

        String appid = "";
        String mchid = "";
        String subAppid = "";
        String subMchid = "";
        String key = "";

        WeixinPayAccount weixinPayAccount = new WeixinPayAccount(appid, null, key, mchid, null, null, null, null, subAppid, subMchid);

        WeixinPayProxy weixinPayProxy = new WeixinPayProxy(weixinPayAccount); // 创建实例

        try {
            OpenIdResult x = weixinPayProxy.authCode2openId("130114439294050121");

            System.err.println(x.getSubOpenId());
        } catch (WeixinException e) {
            e.printStackTrace();
        }
    }

}
