package ru.konstantinova.bot.tgBot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.konstantinova.bot.tgBot.exceptions.ExceptionRespone;
import ru.konstantinova.bot.tgBot.exceptions.JokeNotFoundException;

@ControllerAdvice
public class JokeExceptionsHandler {

    @ExceptionHandler(JokeNotFoundException.class)
    public ResponseEntity<ExceptionRespone> handleJokesNotFound (JokeNotFoundException exception) {

        System.out.println("Joke not found with ID: " + exception.getId());
        return ResponseEntity.notFound().build();
    }
}
