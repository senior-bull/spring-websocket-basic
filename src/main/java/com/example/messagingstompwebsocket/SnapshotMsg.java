package com.example.messagingstompwebsocket;

import java.util.List;

public class SnapshotMsg {

    private final List<StockPrice> prices;

    public SnapshotMsg(List<StockPrice> prices) {
        this.prices = prices;
    }

    public List<StockPrice> getPrices() {
        return prices;
    }
}
