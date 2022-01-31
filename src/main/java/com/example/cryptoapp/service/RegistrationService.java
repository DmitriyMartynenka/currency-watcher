package com.example.cryptoapp.service;

import com.example.cryptoapp.exception.CoinEntityNotFoundException;
import com.example.cryptoapp.model.Coin;
import com.example.cryptoapp.model.User;
import com.example.cryptoapp.model.UserCoins;
import com.example.cryptoapp.repo.CoinRepo;
import com.example.cryptoapp.repo.UserCoinsRepo;
import com.example.cryptoapp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepo userRepo;
    private final UserCoinsRepo userCoinsRepo;
    private final CoinRepo coinRepo;

    @Transactional
    public void register(String username, int coinId) {
        User userByUsername = userRepo.findUserByUsername(username);
        if (userByUsername == null) {
            userByUsername = new User();
            userByUsername.setUsername(username);
            userRepo.save(userByUsername);
        }
        userCoinsRepo.delete(coinId, userRepo.findUserByUsername(username).getId());
        UserCoins userCoins = new UserCoins();
        Coin coin = coinRepo.findById(coinId).orElseThrow(() -> new CoinEntityNotFoundException("Coin not found " + coinId));
        userCoins.setCoin(coin);
        userCoins.setUser(userRepo.findUserByUsername(username));
        userCoins.setRegistrationPrice(coin.getPrice());
        userCoinsRepo.save(userCoins);
    }
}