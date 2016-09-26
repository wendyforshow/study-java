/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.study.rocketMQ;

import com.aliyun.openservices.ons.api.*;

import java.util.Properties;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.study.rocketMQ
 * 功能：
 * 时间：2016-09-26 9:28
 * 作者：Mr.Kiwi
 */
public class MQProducer {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ProducerId, "PID_Clear");// 您在MQ控制台创建的Producer ID
        properties.put(PropertyKeyConst.AccessKey,"xxxxx");// 鉴权用AccessKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "xxxxx");// 鉴权用SecretKey，在阿里云服务器管理控制台创建
        Producer producer = ONSFactory.createProducer(properties);
        // 在发送消息前，必须调用start方法来启动Producer，只需调用一次即可
        producer.start();
        //循环发送消息
//        while(true){
            Message msg = new Message( //
                // Message Topic
                "Topic_Clear",
                // Message Tag,
                // 可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在MQ服务器过滤
                "TagA",
                // Message Body
                // 任何二进制形式的数据， MQ不做任何干预，
                // 需要Producer与Consumer协商好一致的序列化和反序列化方式
                "Hello MQ".getBytes());
            // 设置代表消息的业务关键属性，请尽可能全局唯一，以方便您在无法正常收到消息情况下，可通过MQ控制台查询消息并补发
            // 注意：不设置也不会影响消息正常收发
//            msg.setKey("ORDERID_100");
            // 发送消息，只要不抛异常就是成功
            // 打印Message ID，以便用于消息发送状态查询
            SendResult sendResult = producer.send(msg);
            System.out.println("Send Message success. Message ID is: " + sendResult.getMessageId());
        }
        // 在应用退出前，可以销毁Producer对象
        // 注意：如果不销毁也没有问题
//        producer.shutdown();

//    }

}
