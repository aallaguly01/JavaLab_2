package ru.itis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.api.dto.RefreshTokenDto;
import ru.itis.api.models.RefreshToken;
import ru.itis.api.models.User;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

@Repository
public interface JwtRefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
}
