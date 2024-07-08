package com.sparta.springtestcode.user.controller;

import com.sparta.springtestcode.security.JwtUtil;
import com.sparta.springtestcode.security.UserDetailsImpl;
import com.sparta.springtestcode.user.dto.*;
import com.sparta.springtestcode.user.entity.User;
import com.sparta.springtestcode.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Slf4j(topic = "로그인 및 JWT 생성")
public class UserController {

    final UserService userService;
    final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/user")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest){
        User user = userService.createUser(createUserRequest);
        return ResponseEntity.ok(new CreateUserResponse(user));
    }

    @PostMapping("/user/login")
    public ResponseEntity<LoginUserResponse> loginUser(@RequestBody LoginUserRequest loginUserRequest) {
        LoginUserResponse response = userService.userLogin(loginUserRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/info")
    public ResponseEntity<GetInfoFromJWTResponse> getInfoFromJWT(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok(new GetInfoFromJWTResponse(userDetails.getUser()));
    }

    @GetMapping("/")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("잘 들어 옵니다?",HttpStatus.OK);
    }
}

