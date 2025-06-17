package ru.konstantinova.bot.tgBot.service;

import ru.konstantinova.bot.tgBot.model.User;

import java.util.List;

public interface UserService {
    User registerUser(String username, String password);
    List<User> getAllUsers();
    User changeUserRole(Long userId, String roleName);
}