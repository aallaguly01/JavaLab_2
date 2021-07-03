package ru.itis.api.services;


public interface JwtBlacklistService {
    void add(String token);

    boolean exists(String token);
}
