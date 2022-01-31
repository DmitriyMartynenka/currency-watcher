package com.example.cryptoapp.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RegistrationRequest {
    private String username;
    private int id;
}
