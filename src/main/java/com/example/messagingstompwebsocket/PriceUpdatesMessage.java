package com.example.messagingstompwebsocket;

import java.util.List;

public class PriceUpdatesMessage {

    private final List<StockPrice> prices;

    public PriceUpdatesMessage(List<StockPrice> prices) {
        this.prices = prices;
    }

    public List<StockPrice> getPrices() {
        return prices;
    }
}
