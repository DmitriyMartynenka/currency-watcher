package com.example.cryptoapp.exception;

public class CoinEntityNotFoundException extends IllegalArgumentException {

    public CoinEntityNotFoundException(String message) {
        super(message);
    }
}
