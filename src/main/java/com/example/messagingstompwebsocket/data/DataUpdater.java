package com.example.messagingstompwebsocket.data;

import com.example.messagingstompwebsocket.PriceUpdatesMessage;
import com.example.messagingstompwebsocket.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Component
public class DataUpdater {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    public DataUpdater(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
                this::sendUpdate,
                1,
                1,
                TimeUnit.SECONDS
        );
    }

    public void sendUpdate() {

        messagingTemplate.convertAndSend(
                "/topic/prices",
                new PriceUpdatesMessage(Arrays.asList(new StockPrice("SYM20000", ThreadLocalRandom.current().nextDouble())))
        );
    }
}
