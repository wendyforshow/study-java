/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.csv;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.csv
 * 功能：
 * 时间：2016-12-09 17:23
 * 作者：Mr.Kiwi
 */
public class TestMap {

    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();

        map.put("第1列", "1");
        map.put("第2列", "2");
        map.put("第3列", "3");
        map.put("第4列", "4");
        map.put("第5列", "5");
        map.put("第6列", "6");
        map.put("第7列", "7");
        map.put("第8列", "8");

        System.out.println(JSON.toJSONString(map));


    }

}
