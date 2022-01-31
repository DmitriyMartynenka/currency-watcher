package com.example.cryptoapp.dto;

import com.example.cryptoapp.model.Coin;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinLoreResponse {

    private int Id;
    private String symbol;
    @JsonProperty(value = "price_usd")
    private double price;

    public Coin mapToCoinEntity() {
        Coin coin = new Coin();
        coin.setId(this.Id);
        coin.setSymbol(this.symbol);
        coin.setPrice(this.price);
        return coin;
    }
}
