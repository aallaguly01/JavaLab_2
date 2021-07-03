package ru.itis.api.security.jwt.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.api.models.RefreshToken;
import ru.itis.api.models.User;
import ru.itis.api.repository.JwtRefreshTokenRepository;
import ru.itis.api.redis.services.RedisUsersService;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class JwtTokenServiceImpl implements JwtTokenService {

    @Autowired
    private Algorithm algorithm;

    @Autowired
    private RedisUsersService redisUsersService;

    @Autowired
    private JwtRefreshTokenRepository refreshTokenRepository;

    @Override
    public String getAccessToken(User user) {
        String token = JWT.create()
                .withSubject(user.getId().toString())
                .withClaim("role", user.getRole().toString())
                .withClaim("state", user.getState().toString())
                .withClaim("email", user.getEmail())
                .withClaim("createdAt", LocalDateTime.now().toString())
                .sign(algorithm);

        redisUsersService.addTokenToUser(user, token);

        return token;
    }

    @Override
    public String getRefreshToken(User user) {

        UUID newToken = UUID.randomUUID();
        String token = newToken.toString();

        refreshTokenRepository.save(
                RefreshToken.builder()
                    .token(token)
                    .user(user)
                    .build());

        return newToken.toString();
    }
}
