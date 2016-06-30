/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.annotations.*;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-06-27 21:48
 * 作者：Mr.Kiwi
 */
public class TestHello {

    /**
     * @BeforeSuite: 被注释的方法将在所有测试运行前运行
     * @AfterSuite: 被注释的方法将在所有测试运行后运行
     * @BeforeTest: 被注释的方法将在测试运行前运行
     * @AfterTest: 被注释的方法将在测试运行后运行
     * @BeforeGroups: 被配置的方法将在列表中的gourp前运行。这个方法保证在第一个属于这些组的测试方法调用前立即执行。
     * @AfterGroups: 被配置的方法将在列表中的gourp后运行。这个方法保证在最后一个属于这些组的测试方法调用后立即执行。
     * @BeforeClass: 被注释的方法将在当前类的第一个测试方法调用前运行。
     * @AfterClass: 被注释的方法将在当前类的所有测试方法调用后运行。
     * @BeforeMethod: 被注释的方法将在每一个测试方法调用前运行。
     * @AfterMethod: 被注释的方法将在每一个测试方法调用后运行。
     * @DataProvider 标记一个方法用于为测试方法提供数据。
     * 被注释的方法必须返回Object[][], 其中每个Object[]可以指派为这个测试方法的参数列表。
     * 从这个DataProvider接收数据@Test方法需要使用一个和当前注释相同名称的dataProvider名称
     * name         这个DataProvider的名称
     * @Factory 标记方法作为一个返回对象的工厂，这些对象将被TestNG用于作为测试类。这个方法必须返回Object[]
     * @Parameters 描述如何传递参数给@Test方法
     * value    用于填充这个方法的参数的变量列表
     * @Test 标记一个类或方法作为测试的一部分
     * alwaysRun     如果设置为true，这个测试方法将总是运行，甚至当它依赖的方法失败时。
     * dataProvider     这个测试方法的data provider的名称
     * dataProviderClass     用于查找data provider的类。
     * 如果不指定，将在当前测试方法所在的类或者它的基类上查找data provider。
     * 如果这个属性被指定, 则data provider方法需要是指定类的static方法。
     * dependsOnGroups     当前方法依赖的组列表
     * dependsOnMethods     当前方法依赖的方法列表
     * description     当前方法的描述
     * enabled     当前类的方法/方法是否被激活
     * expectedExceptions     测试方法期望抛出的异常列表。如果没有异常或者抛出的不是列表中的任何一个，当前方法都将标记为失败.
     * groups     当前类/方法所属的组列表
     * invocationCount     当前方法被调用的次数
     * successPercentage     当前方法期望的成功率
     * sequential     如果设置为true，当前测试类上的所有方法保证按照顺序运行。甚至测试们在parallel="true"的情况下.
     * 这个属性只能用于类级别，如果用于方法级别将被忽略。
     * timeOut     当前方法容许花费的最大时间，单位毫秒。
     * threadPoolSize     当前方法的线程池大小。方法将被多线程调用，次数由invocationCount参数指定
     * 注意：如果invocationCount没有指定则这个属性将被忽略
     ***/
    @BeforeMethod
    public void testBeforeMethod() {

        System.out.println("所有方法运行前，进行！");
    }

    @BeforeClass
    public void testBeforeClass() {

        System.out.println("类实例化前，进行！");
    }

    @BeforeTest
    public void testBeforeTest() {

        System.out.println("在test方法进行前！");
    }

    @Test
    public void testHello() {

        System.out.println("test方法运行！");
    }

    @AfterClass
    public void testAfterClass() {

        System.out.println("方法实例化后！");
    }

    @AfterMethod
    public void testAfterMethod() {

        System.out.println("方法调用后！");
    }

    @AfterTest
    public void testAfterTest() {

        System.out.println("test方法进行后！");
    }

}
