/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.hessian.client;

import com.caucho.hessian.client.HessianProxyFactory;
import xyz.mrwood.study.hessian.facade.IHelloHessian;

import java.net.MalformedURLException;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.hessian.client
 * 功能：
 * 时间：2016-09-01 3:24
 * 作者：Mr.Kiwi
 */
public class HessianClient {

    public static void main(String[] args) throws MalformedURLException {

        String url = "http://localhost:8080/hessian";
        System.out.println(url);

        HessianProxyFactory factory = new HessianProxyFactory();
        IHelloHessian helloService = (IHelloHessian) factory.create(IHelloHessian.class, url);
        System.out.println(helloService.hello("kiwi"));
    }

}
