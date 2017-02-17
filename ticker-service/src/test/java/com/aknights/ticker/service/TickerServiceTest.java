package com.aknights.ticker.service;

import com.aknights.ticker.domain.Ticker;
import com.aknights.ticker.repository.TickerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class TickerServiceTest {

	@InjectMocks
	private TickerServiceImpl tickerService;

	@Mock
	private TickerRepository repository;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void shouldFindBySymbol() {

		final Ticker ticker = new Ticker("TEST");

		when(repository.findBySymbol(ticker.getSymbol())).thenReturn(ticker);
		Ticker found = tickerService.getBySymbol(ticker.getSymbol());

		assertEquals(ticker, found);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenSymbolIsEmpty() {
		tickerService.getBySymbol("");
	}

	@Test
	public void shouldCreateTickerWithGivenTickerData() {

		Ticker tickerData = new Ticker("AAPL", "USD", "NYSE", "Apple Inc.");
		Ticker ticker = tickerService.create(tickerData);

		assertEquals(ticker.getSymbol(), tickerData.getSymbol());
		assertEquals(ticker.getExchange(), tickerData.getExchange());
		assertEquals(ticker.getCurrency(), tickerData.getCurrency());
		assertEquals(ticker.getFullName(), tickerData.getFullName());

		verify(repository, times(1)).save(ticker);
	}

	@Test
	public void shouldSaveChangesWhenUpdatedTickerGiven() {

		final Ticker update = new Ticker("AAPL", "USD", "ARCA", "Apple Incorporated");

		final Ticker ticker = new Ticker("AAPL");

		when(repository.findBySymbol("AAPL")).thenReturn(ticker);
		tickerService.saveChanges(update);

		assertEquals(update.getExchange(), ticker.getExchange());

		verify(repository, times(1)).save(ticker);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenNoTickersExistedWithGivenId() {
		final Ticker update = new Ticker("AAPL", "USD", "ARCA", "Apple Incorporated");

		when(repository.findBySymbol("AAPL")).thenReturn(null);
		tickerService.saveChanges(update);
	}
}
