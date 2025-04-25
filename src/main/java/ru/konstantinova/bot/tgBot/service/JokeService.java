package ru.konstantinova.bot.tgBot.service;

import ru.konstantinova.bot.tgBot.model.Joke;
import java.util.List;

public interface JokeService {

    Joke createJoke(Joke joke);

    List<Joke> getAllJoke(String title);

    Joke getJokeById(Long id);

    void updateJoke(Long id, Joke joke);

    void deleteJoke(Long id);
}
