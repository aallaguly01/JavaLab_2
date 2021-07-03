package ru.itis.api.repository;


public interface BlacklistRepository {
    void save(String token);

    boolean exists(String token);
}
