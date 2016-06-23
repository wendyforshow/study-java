/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.test;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;
import xyz.mrwood.study.lombok.Person;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.test
 * 功能：
 * 时间：2016-06-23 12:18
 * 作者：Mr.Kiwi
 */
@Slf4j
public class TestLombok {

    @Test
    public void testSetterAndGetter(){
        val t = "23";
        Person person = new Person();
        person.setAge(123);
        person.setName("kiwi");
        person.setSex('F');

        log.info("new person = {}", person);
    }


    @Test
    public void testPersonNull(){

            testNPE(null);
    }

    public void testNPE(@NonNull String  person){


    }

}
