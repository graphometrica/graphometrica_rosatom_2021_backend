package com.graphometrica.rosatom_2021_backend.service;

import com.graphometrica.rosatom_2021_backend.model.TspInput;
import org.apache.activemq.command.ActiveMQTextMessage;

public interface TspJmsServiceInterface {

    void sendMessageTspSolver(TspInput input);
    void onTspResult(ActiveMQTextMessage message);
}
