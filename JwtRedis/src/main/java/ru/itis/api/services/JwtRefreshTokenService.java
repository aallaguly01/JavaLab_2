package ru.itis.api.services;


import org.springframework.stereotype.Service;
import ru.itis.api.dto.RefreshTokenDto;
import ru.itis.api.dto.TokenDto;

import java.util.Optional;
import java.util.UUID;


public interface JwtRefreshTokenService {
    TokenDto refresh(String token);
}
