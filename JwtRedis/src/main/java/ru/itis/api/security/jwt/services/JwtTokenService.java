package ru.itis.api.security.jwt.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.api.models.User;

import java.util.UUID;


public interface JwtTokenService {
    String getAccessToken(User user);
    String getRefreshToken(User user);
}
