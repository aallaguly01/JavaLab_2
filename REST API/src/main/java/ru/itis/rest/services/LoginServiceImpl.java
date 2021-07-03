package ru.itis.rest.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.rest.dto.EmailPasswordDto;
import ru.itis.rest.dto.TokenDto;
import ru.itis.rest.dto.TokenPairDto;
import ru.itis.rest.models.User;
import ru.itis.rest.models.Token;
import ru.itis.rest.repositories.TokensRepository;
import ru.itis.rest.repositories.UsersRepository;

import java.util.Date;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokensRepository tokensRepository;


    @Value("${jwt.token.secret}")
    private String SECRET;

    @Value("${jwt.token.time}")
    private long EXPIRATION_TIME_IN_SECONDS;



    @SneakyThrows
    @Override
    public TokenPairDto login(EmailPasswordDto emailPassword) {
        return usersRepository.findByEmail(emailPassword.getEmail())
                .map(user -> {
                    if( passwordEncoder.matches(emailPassword.getPassword(), user.getHashPassword())){
                        return doLoginUser(user);
                    } else {
                        throw new UsernameNotFoundException("Invalid username or password");
                    }
                }).orElseThrow((Supplier<Throwable>) () -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public TokenPairDto doLoginUser(User user) {
        String jwt = generateAccessToken(user.getId());
        String refreshToken = createRefreshToken(user);
        return new TokenPairDto(jwt, refreshToken);
    }

    private String createRefreshToken(User user) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = Token.builder()
                .token(tokenValue)
                .user(user)
                .build();

        tokensRepository.save(token);
        return tokenValue;
    }

    private String generateAccessToken(long userId) {
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_SECONDS * 1000))
                .sign(Algorithm.HMAC256(SECRET.getBytes()));
    }
}
