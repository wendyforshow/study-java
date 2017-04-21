/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.csv;

import com.alibaba.fastjson.JSON;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.csv
 * 功能：
 * 时间：2016-12-09 17:03
 * 作者：Mr.Kiwi
 */
public class TestArray {




    public static void main(String[] args) {

        int rows = 2;
        int cloums = 3;

        String[][] arr = new String[rows][cloums];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cloums; j++) {

                arr[i][j] = "";
            }
        }

        System.out.println(JSON.toJSONString(arr));

    }

}
