/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.boot.mybatis;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.boot.mybatis
 * 功能：
 * 时间：2016-06-27 12:00
 * 作者：Mr.Kiwi
 */
public class TestJava {

    @Test
    public void testURL() throws UnsupportedEncodingException {

        String str = URLEncoder.encode("中国", "utf-8");
        System.err.println(str);
        String encode = URLEncoder.encode(str, "utf-8");
        System.err.println(encode);
        System.err.println(URLEncoder.encode(encode, "utf-8"));
        String decode = URLDecoder.decode(str, "utf-8");

    }

}
