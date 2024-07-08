package com.sparta.springtestcode.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    private String username; // ID
    private String password; // PW
    private String info;
}
