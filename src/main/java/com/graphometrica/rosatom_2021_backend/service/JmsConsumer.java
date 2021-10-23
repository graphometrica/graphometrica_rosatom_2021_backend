package com.graphometrica.rosatom_2021_backend.service;

import com.graphometrica.rosatom_2021_backend.config.ActiveMqProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
@Slf4j
public class JmsConsumer implements MessageListener {
    ActiveMqProperties activeMqProperties;

    JmsConsumer(
            ActiveMqProperties activeMqProperties
    ) {
        this.activeMqProperties = activeMqProperties;
    }

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try {
            ActiveMQTextMessage objectMessage = (ActiveMQTextMessage) message;
            String mess = objectMessage.getText();
            log.info("Received Message: " + mess);
        } catch (Exception e) {
            log.error("Received Exception : " + e);
        }
    }
}