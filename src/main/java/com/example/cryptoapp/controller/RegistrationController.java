package com.example.cryptoapp.controller;

import com.example.cryptoapp.dto.RegistrationRequest;
import com.example.cryptoapp.exception.CoinEntityNotFoundException;
import com.example.cryptoapp.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crypto")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/registration")
    public ResponseEntity<Void> subscribe(@RequestBody RegistrationRequest request) {
        final String username = request.getUsername();
        final int coinId = request.getId();
        try {
            registrationService.register(username, coinId);
        } catch (CoinEntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }
}
