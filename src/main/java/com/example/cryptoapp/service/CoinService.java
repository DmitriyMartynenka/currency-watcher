package com.example.cryptoapp.service;

import com.example.cryptoapp.dto.CoinLoreResponse;
import com.example.cryptoapp.exception.CoinEntityNotFoundException;
import com.example.cryptoapp.model.Coin;
import com.example.cryptoapp.repo.CoinRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CoinService {

    private final CoinRepo coinRepo;
    private final RestTemplate restTemplate;

    public void updatePrice(int id) {
        CoinLoreResponse[] forObject = restTemplate.getForObject("https://api.coinlore.net/api/ticker/?id=" + id, CoinLoreResponse[].class);
        if (forObject[0] != null) {
            coinRepo.save(forObject[0].mapToCoinEntity());
        }
    }

    public Iterable<Coin> getAllAvailableCoins() {
        return coinRepo.findAll();
    }

    public Coin getCurrentCoin(int id) {
        return coinRepo.findById(id).orElseThrow(() -> new CoinEntityNotFoundException("Coin not found " + id));
    }
}
