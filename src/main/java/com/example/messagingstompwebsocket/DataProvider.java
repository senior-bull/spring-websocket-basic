package com.example.messagingstompwebsocket;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class DataProvider {

    private static final List<String> SYMBOLS = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            SYMBOLS.add("SYM" + i);
        }
    }

    public List<StockPrice> snapshot() {

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return SYMBOLS.stream()
                .map(sym -> new StockPrice(sym, ThreadLocalRandom.current().nextDouble()))
                .collect(Collectors.toList());
    }
}
