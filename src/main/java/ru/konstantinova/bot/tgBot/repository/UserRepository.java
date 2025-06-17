package ru.konstantinova.bot.tgBot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.konstantinova.bot.tgBot.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}