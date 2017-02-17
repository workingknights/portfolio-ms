package com.aknights.ticker.controller;

import com.aknights.ticker.domain.Ticker;
import com.aknights.ticker.service.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

@RestController
public class TickerController {

    @Autowired
    private TickerService tickerService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public Collection<Ticker> getAllTickers() {
        return tickerService.allTickers();
    }

//    @PreAuthorize("#symbol.equals('AAPL')")
    @RequestMapping(path = "/{symbol}", method = RequestMethod.GET)
    public Ticker getTicker(@PathVariable String symbol) {
        return tickerService.getBySymbol(symbol);
    }

//    @RolesAllowed("ADMIN")
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Ticker createNewTicker(@Valid @RequestBody Ticker ticker) {
        return tickerService.create(ticker);
    }

//    @RolesAllowed("ADMIN")
    @RequestMapping(path = "/", method = RequestMethod.PUT)
    public void saveTicker(@Valid @RequestBody Ticker ticker) {
        tickerService.saveChanges(ticker);
    }
}
