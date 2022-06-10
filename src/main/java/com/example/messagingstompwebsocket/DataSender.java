package com.example.messagingstompwebsocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataSender {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public DataSender(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void sendUpdate(PriceUpdatesMessage msg) {

        simpMessagingTemplate.convertAndSend(msg);
    }
}
