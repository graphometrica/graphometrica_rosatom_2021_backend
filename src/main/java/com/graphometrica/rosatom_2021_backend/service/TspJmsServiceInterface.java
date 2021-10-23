package com.graphometrica.rosatom_2021_backend.service;

import com.graphometrica.rosatom_2021_backend.model.TspInput;

public interface TspJmsServiceInterface {

    void sendMessageTspSolver(TspInput input);
    void onTspResult(String message);
}
