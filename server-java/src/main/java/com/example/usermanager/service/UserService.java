package com.example.usermanager.service;

import com.example.usermanager.model.Role;
import com.example.usermanager.model.User;
import com.example.usermanager.repository.UserRepository;
import com.example.usermanager.security.JwtUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;

    public List<User> getUsers(Integer limit, Integer offset, String name) {
        List<User> users = (name != null)
            ? userRepository.findByNameContainingIgnoreCase(name)
            : userRepository.findAll();

        int from = (offset != null) ? offset : 0;
        int to = (limit != null) ? Math.min(from + limit, users.size()) : users.size();
        return users.subList(from, to);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(String name, int age, boolean isMarried, String password) {
        User user = User.builder()
            .name(name)
            .age(age)
            .isMarried(isMarried)
            .password(password)
            .role(Role.USER)
            .build();
        return userRepository.save(user);
    }

    public User updateUser(String id, boolean isMarried) {
        User user = userRepository.findById(id).orElseThrow();
        user.setMarried(isMarried);
        return userRepository.save(user);
    }

    public Boolean deleteUser(String id) {
        userRepository.deleteById(id);
        return true;
    }
    public String login(String name, String password) {
    User user = userRepository.findByNameContainingIgnoreCase(name)
        .stream().findFirst().orElseThrow();
    if (user.getPassword().equals(password)) {
        return jwtUtil.generateToken(user.getName(), user.getRole().name());
    }
    throw new RuntimeException("Invalid credentials");
}
}