package com.aknights.ticker.service;

import com.aknights.ticker.domain.Ticker;

import java.util.Collection;

public interface TickerService {
    Collection<Ticker> allTickers();

    Ticker getBySymbol(String symbol);

    Ticker create(Ticker ticker);

    void saveChanges(Ticker update);
}
