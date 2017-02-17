package com.aknights.ticker.repository;

import com.aknights.ticker.domain.Ticker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TickerRepository extends CrudRepository<Ticker, String> {

    Ticker findBySymbol(String symbol);

    Collection<Ticker> findAll();
}
