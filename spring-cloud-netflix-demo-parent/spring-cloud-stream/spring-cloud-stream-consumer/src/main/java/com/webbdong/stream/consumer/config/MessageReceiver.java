package com.webbdong.stream.consumer.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 消息消费端监听
 *
 * Sink.class：绑定消费者管道信息。
 * @StreamListener(Sink.INPUT)：监听消息配置，指定了消息为 application中的input。
 * @author Webb Dong
 * @date 2021-10-09 5:03 PM
 */
@EnableBinding(Sink.class)
public class MessageReceiver {

    /**
     * 消息监听
     */
    @StreamListener(Sink.INPUT)
    public void receive(String message) {
        System.out.println("消息监听 message = " + message);
    }

}
