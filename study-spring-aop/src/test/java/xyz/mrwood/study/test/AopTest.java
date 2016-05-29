/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.mrwood.study.service.TargetService;

import javax.annotation.Resource;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.test
 * 功能：
 * 时间：2016-05-28 10:54
 * 作者：Mr.Kiwi
 */
@ContextConfiguration("classpath:spring-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {

    @Resource
    private TargetService targetService;

    @Test
    public void testBefore(){

        Assert.assertEquals(targetService.hello("kiwi"), "hello kiwi");
    }

    @Test
    public void testAround(){

        targetService.test();
    }
}
