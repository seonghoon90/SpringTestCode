package com.sparta.springtestcode.user.dto;

import com.sparta.springtestcode.user.entity.User;
import com.sparta.springtestcode.user.entity.UserRoleEnum;
import lombok.Getter;

@Getter
public class GetInfoFromJWTResponse {
    private String username; // ID
    private String info;
    private UserRoleEnum userRoleEnum;

    public GetInfoFromJWTResponse(User user) {
        this.username = user.getUsername();
        this.info = user.getInfo();
        this.userRoleEnum = user.getRole();
    }
}
