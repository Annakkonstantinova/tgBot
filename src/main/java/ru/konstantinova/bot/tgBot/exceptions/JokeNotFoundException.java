package ru.konstantinova.bot.tgBot.exceptions;

import lombok.Getter;

@Getter
public class JokeNotFoundException extends RuntimeException {

    private final Long id;
    public JokeNotFoundException(Long id) {
        super("Такой шутки нет: " + id);
        this.id=id;
    }
    public Long getId() {
        return id;
    }
}