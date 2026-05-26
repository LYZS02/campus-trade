package com.campus.trade.controller;

import com.campus.trade.entity.User;
import com.campus.trade.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String,String> body) {
        try {
            User user = userService.register(
                body.get("username"), body.get("password"),
                body.get("name"), body.get("phone")
            );
            return ResponseEntity.ok(Map.of(
                "id", user.getId(), "username", user.getUsername(),
                "name", user.getName(), "role", user.getRole()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> body) {
        try {
            User user = userService.login(body.get("username"), body.get("password"));
            return ResponseEntity.ok(Map.of(
                "id", user.getId(), "username", user.getUsername(),
                "name", user.getName(), "phone", user.getPhone(), "role", user.getRole()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return userService.findById(id)
                .map(u -> ResponseEntity.ok(Map.of(
                    "id", u.getId(), "name", u.getName(), "phone", u.getPhone(), "role", u.getRole()
                )))
                .orElse(ResponseEntity.notFound().build());
    }
}
