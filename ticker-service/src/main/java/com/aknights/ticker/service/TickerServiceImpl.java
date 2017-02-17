package com.aknights.ticker.service;

import com.aknights.ticker.domain.Ticker;
import com.aknights.ticker.repository.TickerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;

@Service
public class TickerServiceImpl implements TickerService {

    private static final Logger logger = LoggerFactory.getLogger(TickerServiceImpl.class);

    @Autowired
    private TickerRepository repository;

    @Override
    public Collection<Ticker> allTickers() {
        return repository.findAll();
    }

    @Override
    public Ticker getBySymbol(String symbol) {
        Assert.hasLength(symbol);
        return repository.findBySymbol(symbol);
    }

    @Override
    public Ticker create(Ticker ticker) {

        Ticker existing = repository.findBySymbol(ticker.getSymbol());
        Assert.isNull(existing, "ticker already exists: " + ticker.getSymbol());

        repository.save(ticker);

        logger.info("new ticker has been created: " + ticker);

        return ticker;
    }

    @Override
    public void saveChanges(Ticker update) {
        Ticker ticker = repository.findBySymbol(update.getSymbol());
        Assert.notNull(ticker, "Can't find ticker with symbol: " + update.getSymbol());

        ticker.setCurrency(update.getCurrency());
        ticker.setExchange(update.getExchange());
        ticker.setFullName(update.getFullName());

        repository.save(ticker);

        logger.debug("ticker {} chanegs have been saved", ticker.getSymbol());
    }

}
