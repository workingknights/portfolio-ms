package com.aknights.ticker.controller;

import com.aknights.ticker.TickerApplication;
import com.aknights.ticker.domain.Ticker;
import com.aknights.ticker.service.TickerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.security.auth.UserPrincipal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TickerApplication.class)
@WebAppConfiguration
public class TickerControllerTest {

	private static final ObjectMapper mapper = new ObjectMapper();

	@InjectMocks
	private TickerController tickerController;

	@Mock
	private TickerService tickerService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(tickerController).build();
	}

	@Test
	public void shouldGetTickerById() throws Exception {

		final Ticker ticker = new Ticker("AAPL");

		when(tickerService.getBySymbol(ticker.getSymbol())).thenReturn(ticker);

		mockMvc.perform(get("/" + ticker.getSymbol()))
				.andExpect(jsonPath("$.symbol").value(ticker.getSymbol()))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldSaveTicker() throws Exception {

		final Ticker ticker = new Ticker("AAPL", "USD", "NYSE", "Apple Inc.");
		ticker.setSymbol("abd123");

		String json = mapper.writeValueAsString(ticker);

		mockMvc.perform(put("/")
				.principal(new UserPrincipal("test"))
				.contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldRegisterNewTicker() throws Exception {

		final Ticker ticker = new Ticker("AAPL", "USD", "NYSE", "Apple Inc.");

		String json = mapper.writeValueAsString(ticker);
		System.out.println(json);
		mockMvc.perform(post("/")
				.principal(new UserPrincipal("test"))
				.contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
	}

}
