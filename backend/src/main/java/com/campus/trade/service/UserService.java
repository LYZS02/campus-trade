package com.campus.trade.service;

import com.campus.trade.entity.User;
import com.campus.trade.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String username, String password, String name, String phone) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("用户名已存在");
        }
        User user = new User(username, password, name, phone);
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        Optional<User> opt = userRepository.findByUsername(username);
        if (opt.isEmpty() || !opt.get().getPassword().equals(password)) {
            throw new RuntimeException("用户名或密码错误");
        }
        return opt.get();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
