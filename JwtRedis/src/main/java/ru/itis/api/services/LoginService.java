package ru.itis.api.services;


import ru.itis.api.dto.EmailPasswordDto;
import ru.itis.api.dto.TokenDto;

public interface LoginService {
    TokenDto login(EmailPasswordDto emailPassword);
}
