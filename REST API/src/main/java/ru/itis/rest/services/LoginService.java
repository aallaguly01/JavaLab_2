package ru.itis.rest.services;

import org.springframework.stereotype.Service;
import ru.itis.rest.dto.EmailPasswordDto;
import ru.itis.rest.dto.TokenDto;
import ru.itis.rest.dto.TokenPairDto;
import ru.itis.rest.models.User;

@Service
public interface LoginService {
    TokenPairDto login(EmailPasswordDto emailPassword);
    TokenPairDto doLoginUser(User user);
}
