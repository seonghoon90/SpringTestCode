package com.sparta.springtestcode.user.service;

import com.sparta.springtestcode.security.JwtUtil;
import com.sparta.springtestcode.user.dto.CreateUserRequest;
import com.sparta.springtestcode.user.dto.LoginUserRequest;
import com.sparta.springtestcode.user.dto.LoginUserResponse;
import com.sparta.springtestcode.user.entity.User;
import com.sparta.springtestcode.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    final UserRepository userRepository;

    final PasswordEncoder passwordEncoder;

    final JwtUtil jwtUtil;

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public User createUser(CreateUserRequest createUserRequest) {
        String encodingPassword = passwordEncoder.encode(createUserRequest.getPassword());
        User user = new User(createUserRequest, encodingPassword);
        return userRepository.save(user);
    }

    public LoginUserResponse userLogin(LoginUserRequest loginUserRequest) {
        User user = userRepository.findByUsername(loginUserRequest.getUsername()).orElseThrow(
                () -> new IllegalArgumentException("일치하는 사용자가 없습니다.")
        );

        if (passwordEncoder.matches(loginUserRequest.getPassword(), user.getPassword())) {
            String token = jwtUtil.createToken(user.getUsername(), user.getRole());
            return new LoginUserResponse(token, user.getUsername());
        } else {
            throw new IllegalArgumentException("비밀번호 오류");
        }
    }
}
