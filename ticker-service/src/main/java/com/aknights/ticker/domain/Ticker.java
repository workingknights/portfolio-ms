package com.aknights.ticker.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "tickers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker {
    @Id
    @Length(max = 7)
    private String symbol;

    @NotNull
    @Length(min = 3, max = 3)
    private String currency;

    @NotNull
    private String exchange;

    private String fullName;

    public Ticker() {
    }

    public Ticker(String symbol, String currency, String exchange, String fullName) {
        this.symbol = symbol;
        this.currency = currency;
        this.exchange = exchange;
        this.fullName = fullName;
    }

    public Ticker(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCurrency() {
        return currency;
    }

    public String getExchange() {
        return exchange;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "symbol='" + symbol + '\'' +
                ", currency='" + currency + '\'' +
                ", exchange='" + exchange + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticker ticker = (Ticker) o;

        return symbol != null ? symbol.equals(ticker.symbol) : ticker.symbol == null;
    }

    @Override
    public int hashCode() {
        return symbol != null ? symbol.hashCode() : 0;
    }
}
