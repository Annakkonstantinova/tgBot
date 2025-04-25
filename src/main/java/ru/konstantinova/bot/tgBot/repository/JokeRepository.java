package ru.konstantinova.bot.tgBot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.konstantinova.bot.tgBot.model.Joke;
import java.util.List;
import java.util.Optional;

public interface JokeRepository extends CrudRepository<Joke, Long> {

}