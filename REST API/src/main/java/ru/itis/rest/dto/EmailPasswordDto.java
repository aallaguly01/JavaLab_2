package ru.itis.rest.dto;

import lombok.Data;

@Data
public class EmailPasswordDto {
    private String email;
    private String password;
}
