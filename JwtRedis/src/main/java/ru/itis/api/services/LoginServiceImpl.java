package ru.itis.api.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.api.dto.EmailPasswordDto;
import ru.itis.api.dto.TokenDto;
import ru.itis.api.models.User;
import ru.itis.api.redis.services.RedisUsersService;
import ru.itis.api.repository.UsersRepository;
import ru.itis.api.security.jwt.services.JwtTokenService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import java.util.function.Supplier;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private Algorithm algorithm;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenService jwtUtil;

    @SneakyThrows
    @Override
    public TokenDto login(EmailPasswordDto emailPassword) {
        User user = usersRepository.findByEmail(emailPassword.getEmail())
                .orElseThrow((Supplier<Throwable>) () -> new UsernameNotFoundException("User not found"));
        if (passwordEncoder.matches(emailPassword.getPassword(), user.getHashPassword())) {
            return TokenDto.builder()
                    .accessToken(jwtUtil.getAccessToken(user))
                    .refreshToken(jwtUtil.getRefreshToken(user))
                    .build();
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }
}
