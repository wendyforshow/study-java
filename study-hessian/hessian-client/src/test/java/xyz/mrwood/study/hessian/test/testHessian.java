/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.hessian.test;

import com.caucho.hessian.client.HessianProxyFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import xyz.mrwood.study.hession.facade.IHelloHessian;
import xyz.mrwood.study.hession.facade.IHessianDemo;

import java.net.MalformedURLException;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.hessian.test
 * 功能：
 * 时间：2016-09-02 2:19
 * 作者：Mr.Kiwi
 */
@Test
public class testHessian {

    private HessianProxyFactory hessianProxyFactory;
    private static final String BASE_URL = "http://localhost:8080/";

    @BeforeMethod
    public void loadHessianFactory(){

        hessianProxyFactory = new HessianProxyFactory();
    }

    @Test
    public void testHelloHessian() throws MalformedURLException {

        IHelloHessian helloHessian =
            (IHelloHessian) hessianProxyFactory.create(IHelloHessian.class,
                BASE_URL + "helloHessian");

        Assert.assertEquals(helloHessian.hello("kiwi").equals("Hello kiwi"), true);
    }

    @Test
    public void testHessianDemo() throws MalformedURLException {

        IHessianDemo hessianDemo =
            (IHessianDemo) hessianProxyFactory.create(IHessianDemo.class, BASE_URL + "hessianDemo");

        int add = hessianDemo.add(1, 1);
        Assert.assertEquals(add == 2, true);
    }

}
