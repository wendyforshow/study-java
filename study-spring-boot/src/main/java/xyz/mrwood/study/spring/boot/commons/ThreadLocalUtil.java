/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.boot.commons;

import java.util.HashMap;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.boot.commons
 * 功能：
 * 时间：2016-06-20 21:50
 * 作者：Mr.Kiwi
 */
public class ThreadLocalUtil {

    private static ThreadLocal<HashMap<String, Object>> threadLocal = new ThreadLocal(){

        @Override
        protected Object initialValue() {

            return new HashMap<>();
        }


    };

    public static void put(String key, Object value){

        threadLocal.get().put(key, value);
    }

    public static Object get(String key){

        return threadLocal.get().get(key);
    }

    public static void remove(){

        threadLocal.remove();
    }

}
