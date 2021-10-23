package com.graphometrica.rosatom_2021_backend.controller;

import com.graphometrica.rosatom_2021_backend.service.JmsProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProduceMessageController {
    JmsProducer jmsProducer;

    ProduceMessageController(JmsProducer jmsProducer) {
        this.jmsProducer = jmsProducer;
    }

    @PostMapping(value="/api/topic")
    public String sendMessageToTopic(@RequestBody String message){
        jmsProducer.sendMessageToTopic(message);
        return message;
    }

    @PostMapping(value="/api/queue")
    public String sendMessageToQueue(@RequestBody String message){
        jmsProducer.sendMessageToQueue(message);
        return message;
    }
}
