package com.graphometrica.rosatom_2021_backend.service;

import com.graphometrica.rosatom_2021_backend.model.Edge;
import com.graphometrica.rosatom_2021_backend.model.TspResult;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;

import java.util.List;

public interface TspJmsServiceInterface {

    void sendMessageTspSolver(List<Edge> edges);
    TspResult onTspResult(ActiveMQTextMessage message);
}
