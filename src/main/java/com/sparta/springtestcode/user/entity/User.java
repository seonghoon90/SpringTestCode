package com.sparta.springtestcode.user.entity;

import com.sparta.springtestcode.user.dto.CreateUserRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 유저 id

    @Column(nullable = false, unique = true)
    private String username; // ID

    @Column(nullable = false)
    private String password; // PW

    @Column(nullable = false)
    private String info;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public User(String username, String password, UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(CreateUserRequest createUserRequest, String password) {
        this.username = createUserRequest.getUsername();
        this.password = password;
        this.info = createUserRequest.getInfo();
        this.role = UserRoleEnum.USER;
    }
}
