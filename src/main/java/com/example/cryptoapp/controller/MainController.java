package com.example.cryptoapp.controller;

import com.example.cryptoapp.exception.CoinEntityNotFoundException;
import com.example.cryptoapp.model.Coin;
import com.example.cryptoapp.service.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crypto")
@RequiredArgsConstructor
public class MainController {

    private final CoinService coinService;

    @GetMapping("/all")
    public Iterable<Coin> getAllCrypts() {
        return coinService.getAllAvailableCoins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coin> getCurrentCoin(@PathVariable int id) {
        try {
            return ResponseEntity.ok(coinService.getCurrentCoin(id));
        } catch (CoinEntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
