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
 * 时间：2016-09-26 10:15
 * 作者：Mr.Kiwi
 */
public class MQConsumer {

    public static void main(String[] args) {


        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId, "CID_Clear");// 您在MQ控制台创建的Producer ID
        properties.put(PropertyKeyConst.AccessKey,"xxxxx");// 鉴权用AccessKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "xxxxx");// 鉴权用SecretKey，在阿里云服务器管理控制台创建
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("Topic_Clear", "*", new MessageListener() {
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);

                System.err.println(new String(message.getBody()));

                return Action.CommitMessage;
            }
        });
        consumer.start();
        System.out.println("Consumer Started");
    }

}
