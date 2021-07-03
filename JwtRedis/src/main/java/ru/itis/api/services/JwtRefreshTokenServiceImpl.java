package ru.itis.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.api.dto.RefreshTokenDto;
import ru.itis.api.dto.TokenDto;
import ru.itis.api.models.RefreshToken;
import ru.itis.api.models.User;
import ru.itis.api.repository.JwtRefreshTokenRepository;
import ru.itis.api.security.jwt.services.JwtTokenService;

@Service
public class JwtRefreshTokenServiceImpl implements JwtRefreshTokenService {

    @Autowired
    JwtRefreshTokenRepository refreshTokenRepository;

    @Autowired
    private JwtTokenService jwtUtil;

    @Override
    public TokenDto refresh(String token) {

        RefreshToken refreshToken = refreshTokenRepository.findByToken(token )
                .orElseThrow(() -> new UsernameNotFoundException("Refresh token is not in database!"));



        if (refreshToken != null){
            User user = refreshToken.getUser();

            return TokenDto.builder()
                        .accessToken(jwtUtil.getAccessToken(user))
                        .refreshToken(jwtUtil.getRefreshToken(user))
                        .build();
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }


}
