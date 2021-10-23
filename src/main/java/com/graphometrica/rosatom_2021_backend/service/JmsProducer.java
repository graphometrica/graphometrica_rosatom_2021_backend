package com.graphometrica.rosatom_2021_backend.service;

import com.graphometrica.rosatom_2021_backend.config.ActiveMqProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JmsProducer {
    private JmsTemplate jmsTemplate;
    ActiveMqProperties activeMqProperties;

    JmsProducer(
            JmsTemplate jmsTemplate,
            ActiveMqProperties activeMqProperties
    ) {
        this.jmsTemplate = jmsTemplate;
        this.activeMqProperties = activeMqProperties;
    }

    public void sendMessage(String message) {
        try{
            log.info("Attempting Send message to Topic: "+ activeMqProperties.getTopic());
            jmsTemplate.convertAndSend(activeMqProperties.getTopic(), message);
        } catch(Exception e){
            log.error("Recieved Exception during send Message: ", e);
        }
    }
}
