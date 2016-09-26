/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-09-23 10:17
 * 作者：Mr.Kiwi
 */
public class TestArrayList {

    @Test
    public  void testArrayList(){

        String[] arr = new String[]{"2", "3", "5"};

//        Arrays.ArrayList

        List<String> list = Arrays.asList(arr);
//       list.add("333");

        ArrayList arrayList = new ArrayList(list);
        arrayList.add("124");

        System.err.println(arrayList);
    }

}
