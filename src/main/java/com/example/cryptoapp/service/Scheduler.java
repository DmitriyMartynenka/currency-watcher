package com.example.cryptoapp.service;

import com.example.cryptoapp.dto.InfoResponse;
import com.example.cryptoapp.repo.UserCoinsRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Scheduler {

    final int[] coinsId = {90, 80, 48543};

    private final CoinService coinService;
    private final UserCoinsRepo coins;

    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(fixedRate = 60000)
    public void updateCoinPrices() {
        for (int i : coinsId) {
            coinService.updatePrice(i);
        }
        printInfo();
    }

    public void printInfo() {
        List<InfoResponse> response = coins.findInfoForNotify();
        if (!response.isEmpty()) {
            for (InfoResponse info : response) {
                log.warn(info.toString());
            }
        }
    }
}