package com.graphometrica.rosatom_2021_backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphometrica.rosatom_2021_backend.config.ActiveMqProperties;
import com.graphometrica.rosatom_2021_backend.model.Edge;
import com.graphometrica.rosatom_2021_backend.model.TspResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TspJmsService implements TspJmsServiceInterface {

    JmsTemplate jmsTemplate;
    ActiveMqProperties activeMqProperties;
    ObjectMapper mapper = new ObjectMapper();

    TspJmsService(ActiveMqProperties activeMqProperties,
                  JmsTemplate jmsTemplate) {
        this.activeMqProperties = activeMqProperties;
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessageTspSolver(List<Edge> edges) {
        String queue = activeMqProperties.getRosatom().getTspInputQueue();

        try{
            String message = mapper.writeValueAsString(edges);
            log.info("Attempting Send message to Queue: "+ queue);
            log.info("message : " + mapper.writeValueAsString(edges));
            jmsTemplate.convertAndSend(new ActiveMQQueue(queue), message);
        } catch(Exception e){
            log.error("Recieved Exception during send Message: ", e);
        }
    }

    @JmsListener(destination = "${active-mq.rosatom.tsp-output-queue}", containerFactory = "jmsQueueListenerContainerFactory")
    public TspResult onTspResult(ActiveMQTextMessage message) {
        try {
            String resultRaw = message.getText();
            TspResult result = mapper.readValue(resultRaw, TspResult.class);
            log.info("Received Queue Message: " + result.getSolutionType());
            return result;
        } catch (Exception e) {
            log.error("Received Queue Exception : " + e);
            return null;
        }
    }
}
