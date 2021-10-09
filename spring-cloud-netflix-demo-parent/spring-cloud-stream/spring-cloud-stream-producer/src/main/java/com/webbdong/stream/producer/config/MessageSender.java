package com.webbdong.stream.producer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 输出管道绑定
 *
 * Source.class：绑定一个输出消息通道 Channel
 * MessageChannel：消息发送对象，默认是 DirectWithAttributesChannel，发消息在 AbstractMessageChannel 中完成。
 * MessageBuilder.withPayload：构建消息。
 * @author Webb Dong
 * @date 2021-10-09 3:53 PM
 */
@EnableBinding(Source.class)
public class MessageSender {

    /**
     * 消息发送管道
     */
    private MessageChannel output;

    @Autowired
    public MessageSender(MessageChannel output) {
        this.output = output;
    }

    /**
     * 发送消息
     */
    public boolean send(Object message) {
        System.out.println("******* send message: " + message);
        return output.send(MessageBuilder.withPayload(message).build());
    }

}
