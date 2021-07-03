package ru.itis.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.rest.dto.EmailPasswordDto;
import ru.itis.rest.dto.TokenDto;
import ru.itis.rest.dto.TokenPairDto;
import ru.itis.rest.services.LoginService;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

//    @PostMapping("/login")
//    public ResponseEntity<TokenDto> login(@RequestBody EmailPasswordDto emailPassword) {
//        return ResponseEntity.ok(loginService.login(emailPassword));
//    }

    @PostMapping("/login")
    public ResponseEntity<TokenPairDto> tokenPostLogin(@Valid @RequestBody EmailPasswordDto emailPassword){
        return  ResponseEntity.ok(loginService.login(emailPassword));
    }
}
