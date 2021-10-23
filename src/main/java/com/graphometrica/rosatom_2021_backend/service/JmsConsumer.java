package com.graphometrica.rosatom_2021_backend.service;

import com.graphometrica.rosatom_2021_backend.config.ActiveMqProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
@Slf4j
public class JmsConsumer {
    ActiveMqProperties activeMqProperties;

    JmsConsumer(
            ActiveMqProperties activeMqProperties
    ) {
        this.activeMqProperties = activeMqProperties;
    }

    @JmsListener(destination = "${active-mq.topic}", containerFactory = "jmsTopicListenerContainerFactory")
    public void onTopicMessage(Message message) {
        try {
            ActiveMQTextMessage objectMessage = (ActiveMQTextMessage) message;
            String mess = objectMessage.getText();
            log.info("Received Topic Message: " + mess);
        } catch (Exception e) {
            log.error("Received Topic Exception : " + e);
        }
    }

    @JmsListener(destination = "${active-mq.queue}", containerFactory = "jmsQueueListenerContainerFactory")
    public void onQueueMessage(Message message) {
        try {
            ActiveMQTextMessage objectMessage = (ActiveMQTextMessage) message;
            String mess = objectMessage.getText();
            log.info("Received Queue Message: " + mess);
        } catch (Exception e) {
            log.error("Received Queue Exception : " + e);
        }
    }
}