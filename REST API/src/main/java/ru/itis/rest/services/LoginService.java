package ru.itis.rest.services;

import ru.itis.rest.dto.EmailPasswordDto;
import ru.itis.rest.dto.TokenDto;

public interface LoginService {
    TokenDto login(EmailPasswordDto emailPassword);
}
