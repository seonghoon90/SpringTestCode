package com.sparta.springtestcode.user.dto;

import com.sparta.springtestcode.user.entity.User;
import com.sparta.springtestcode.user.entity.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {
    private String username; // ID
    private String info;
    private UserRoleEnum userRoleEnum;

    public CreateUserResponse(User user) {
        this.username = user.getUsername();
        this.info = user.getInfo();
        this.userRoleEnum = user.getRole();
    }
}
