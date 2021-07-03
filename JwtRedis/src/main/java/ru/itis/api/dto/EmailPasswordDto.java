package ru.itis.api.dto;

import lombok.Data;


@Data
public class EmailPasswordDto {
    private String email;
    private String password;
}
