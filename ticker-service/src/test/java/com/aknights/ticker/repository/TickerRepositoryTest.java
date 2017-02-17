package com.aknights.ticker.repository;

import com.aknights.ticker.TickerApplication;
import com.aknights.ticker.domain.Ticker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TickerApplication.class)
public class TickerRepositoryTest {

	@Autowired
	private TickerRepository repository;

	@Test
	public void shouldFindTickerBySymbol() {

		Ticker stub = getStubTicker();
		repository.save(stub);

		Ticker found = repository.findBySymbol(stub.getSymbol());
		assertEquals(stub.getCurrency(), found.getCurrency());
		assertEquals(stub.getExchange(), found.getExchange());
		assertEquals(stub.getFullName(), found.getFullName());
		assertEquals(stub.getSymbol(), found.getSymbol());
	}

	private Ticker getStubTicker() {
		return new Ticker("AAPL", "USD", "NYSE", "Apple Inc.");
	}
}
