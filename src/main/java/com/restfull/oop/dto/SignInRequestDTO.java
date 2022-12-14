package com.restfull.oop.dto;

import lombok.Data;

@Data
public class SignInRequestDTO {
    private String email;
    private String password;
}
