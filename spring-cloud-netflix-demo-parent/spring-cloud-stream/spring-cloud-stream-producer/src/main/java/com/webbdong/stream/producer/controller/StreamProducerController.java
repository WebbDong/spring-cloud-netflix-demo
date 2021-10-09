package com.webbdong.stream.producer.controller;

import com.webbdong.stream.common.model.MessageModel;
import com.webbdong.stream.producer.config.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Webb Dong
 * @date 2021-10-09 4:13 PM
 */
@RestController
public class StreamProducerController {

    private MessageSender messageSender;

    @Autowired
    public StreamProducerController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam("id") Long id, @RequestParam("data") String data) {
        messageSender.send(MessageModel.builder()
                .id(id)
                .data(data)
                .build());
        return "success";
    }

}
