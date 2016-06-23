/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.test;

import lombok.NonNull;
import lombok.SneakyThrows;
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
        Person person = new Person();
        person.setAge(123);
        person.setName("kiwi");
        person.setSex('F');


        System.err.println(person);

        log.info("new person = {}", person);
    }

    @Test
    public void testVal(){

        val t = "23";
        System.err.println(t.getClass());
    }

    @Test
    public void testBuilder(){

        Person person1 = Person.builder().age(18).name("kiwifly").sex('M').book("java").book("html").build();
        System.err.println(person1);
    }

    @Test
    public void testPersonNull(){

            testNPE(null);
    }

    public void testNPE(@NonNull String  person){


    }


    @Test
    public void testEx(){

        testException();
    }

    @SneakyThrows
    public void testException(){

        throw new Exception();
    }



}
