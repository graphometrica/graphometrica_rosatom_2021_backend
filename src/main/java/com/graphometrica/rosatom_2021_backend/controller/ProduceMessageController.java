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

    @PostMapping(value="/api/employee")
    public String sendMessage(@RequestBody String message){
        jmsProducer.sendMessage(message);
        return message;
    }
}
