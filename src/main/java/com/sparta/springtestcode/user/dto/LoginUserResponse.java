package com.sparta.springtestcode.user.dto;

import com.sparta.springtestcode.user.entity.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginUserResponse {
    private String token;
    private String username; // ID
}
