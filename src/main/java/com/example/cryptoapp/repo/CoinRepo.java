package com.example.cryptoapp.repo;

import com.example.cryptoapp.model.Coin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepo extends CrudRepository<Coin, Integer> {
}