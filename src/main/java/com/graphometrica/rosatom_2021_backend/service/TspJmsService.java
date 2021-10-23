package com.graphometrica.rosatom_2021_backend.service;

import com.graphometrica.rosatom_2021_backend.config.ActiveMqProperties;
import com.graphometrica.rosatom_2021_backend.model.Edge;
import com.graphometrica.rosatom_2021_backend.model.TspResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TspJmsService implements TspJmsServiceInterface {

    JmsTemplate jmsTemplate;
    ActiveMqProperties activeMqProperties;

    TspJmsService(ActiveMqProperties activeMqProperties,
                  JmsTemplate jmsTemplate) {
        this.activeMqProperties = activeMqProperties;
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessageTspSolver(List<Edge> edges) {
        String queue = activeMqProperties.getRosatom().getTspOutputQueue();

        try{
            log.info("Attempting Send message to Queue: "+ queue);
            log.info("message");
            jmsTemplate.convertAndSend(new ActiveMQQueue(queue), edges);
        } catch(Exception e){
            log.error("Recieved Exception during send Message: ", e);
        }
    }

    @Override
    public TspResult onTspResult() {
        return null;
    }
}
