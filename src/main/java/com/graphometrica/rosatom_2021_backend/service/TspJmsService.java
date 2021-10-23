package com.graphometrica.rosatom_2021_backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphometrica.rosatom_2021_backend.config.ActiveMqProperties;
import com.graphometrica.rosatom_2021_backend.model.Edge;
import com.graphometrica.rosatom_2021_backend.model.TspResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TspJmsService implements TspJmsServiceInterface {

    private final JmsTemplate jmsTemplate;
    private final ActiveMqProperties activeMqProperties;
    private final ObjectMapper mapper = new ObjectMapper();
    private final GraphService graphService;

    public void sendMessageTspSolver(List<Edge> edges, String routerId) {
        String queue = activeMqProperties.getRosatom().getTspInputQueue();

        try{
            String message = mapper.writeValueAsString(edges);
            log.info("Attempting Send message to Queue: "+ queue);
            log.info("message : " + mapper.writeValueAsString(edges));
            jmsTemplate.convertAndSend(new ActiveMQQueue(queue), message, msg -> {
                msg.setStringProperty("routerId", routerId);
                return msg;
            });
        } catch(Exception e){
            log.error("Recieved Exception during send Message: ", e);
        }
    }

    @JmsListener(destination = "${active-mq.rosatom.tsp-output-queue}", containerFactory = "jmsQueueListenerContainerFactory")
    public void onTspResult(ActiveMQTextMessage message) {
        try {
            String resultRaw = message.getText();
            TspResult result = mapper.readValue(resultRaw, TspResult.class);
            log.info("Received Queue Message: " + result.getSolutionType());
        } catch (Exception e) {
            log.error("Received Queue Exception : " + e);
        }
    }
}
