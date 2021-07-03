package ru.itis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.api.models.User;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
