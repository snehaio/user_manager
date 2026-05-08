package com.example.usermanager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private int age;
    private boolean isMarried;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}