package ru.itis.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.dto.EmailPasswordDto;
import ru.itis.api.dto.RefreshTokenDto;
import ru.itis.api.dto.TokenDto;
import ru.itis.api.models.RefreshToken;
import ru.itis.api.models.User;
import ru.itis.api.repository.JwtRefreshTokenRepository;
import ru.itis.api.services.JwtRefreshTokenService;
import ru.itis.api.services.LoginService;


@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtRefreshTokenRepository refreshTokenRepository;

    @Autowired
    private JwtRefreshTokenService refreshToken;


    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody EmailPasswordDto emailPassword) {
        return ResponseEntity.ok(loginService.login(emailPassword));
    }

//    @GetMapping("/refresh")
//    public void refresh(){
//
//    }

//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody EmailPasswordDto emailPassword) {
////        HttpHeaders headers = new HttpHeaders();
////        headers.add("access", loginService.login(emailPassword).toString());
//
//        String token = "16c4cd3e-3310-4bfd-84fb-83b941f0f642";
////        UUID uuid = UUID.fromString(token);
////        RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
////                .orElseThrow(() -> new UsernameNotFoundException("Refresh token is not in database!"));
//
//
//        User user = refreshToken.getUser();
//
////        User user = refreshTokenRepository.findByToken(token);
//
//
//        return ResponseEntity.ok()
////                .headers(headers)
//                .body(user.getEmail());
//    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenDto> refreshtoken(@RequestBody RefreshTokenDto token) {
        return ResponseEntity.ok(refreshToken.refresh(token.getRefreshToken()));
    }

}
