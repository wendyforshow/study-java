/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.testng.annotations.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-08-16 1:32
 * 作者：Mr.Kiwi
 */
public class TestRxJava {


    @Test
    public void textHelloWorld(){

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>(

        ) {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("hello RxJava");
                int i = 1 / 0;
                subscriber.onCompleted();
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

                System.err.println(throwable.getMessage());
            }

            @Override
            public void onNext(String s) {

                System.out.println(s);
            }
        };


        observable.subscribe(subscriber);
    }


    @Test
    public void  testJust(){

        Observable.just("hello world").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }


    @Test
    public void testMap(){

        Observable.just("hello World").map(new Func1<String, String>() {
            @Override
            public String call(String s) {

                return s + " kiwi";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {

                System.out.println(s);
            }
        });
    }

}
