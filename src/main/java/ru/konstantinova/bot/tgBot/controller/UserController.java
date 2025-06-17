package ru.konstantinova.bot.tgBot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.konstantinova.bot.tgBot.model.User;
import ru.konstantinova.bot.tgBot.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestParam String username,
            @RequestParam String password) {
        return ResponseEntity.ok(userService.registerUser(username, password));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{userId}/role")
    public ResponseEntity<User> changeUserRole(
            @PathVariable Long userId,
            @RequestParam String roleName) {
        return ResponseEntity.ok(userService.changeUserRole(userId, roleName));
    }
}