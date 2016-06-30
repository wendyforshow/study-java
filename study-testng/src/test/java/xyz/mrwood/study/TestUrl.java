/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-06-29 20:42
 * 作者：Mr.Kiwi
 */
public class TestUrl {

    @Test
    public void testUrl() throws UnsupportedEncodingException {

        String decode =
            URLDecoder.decode(URLDecoder.decode("http%253A%252F%252Fa.iyoudui.com%253A8080%252Fvbizplatform-web-home-0.0.1-SNAPSHOT%252Fcar%252Fportal", "utf-8"), "utf-8");

        System.err.println(decode);
    }

}
