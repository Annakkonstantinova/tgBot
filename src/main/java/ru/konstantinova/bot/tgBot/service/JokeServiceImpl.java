package ru.konstantinova.bot.tgBot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.konstantinova.bot.tgBot.exceptions.JokeNotFoundException;
import ru.konstantinova.bot.tgBot.model.Joke;
import ru.konstantinova.bot.tgBot.repository.JokeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RequiredArgsConstructor
@Service
public class JokeServiceImpl implements JokeService {

    private final JokeRepository jokeRepository;

    @Override
    public Joke createJoke(Joke joke) {
        return jokeRepository.save(joke);
    }

    @Override
    public List<Joke> getAllJoke(String title) {
        Iterable<Joke> jokesIterable = jokeRepository.findAll();

        if (title != null && !title.isEmpty()) {
            return StreamSupport.stream(jokesIterable.spliterator(), false)
                    .filter(joke -> joke.getTitle() != null && joke.getTitle().contains(title))
                    .collect(Collectors.toList());
        }

        return StreamSupport.stream(jokesIterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Joke getJokeById(Long id) {
        Optional<Joke> joke = jokeRepository.findById(id);
        return joke.orElseThrow(() -> new JokeNotFoundException(id));
    }

    @Override
    public void updateJoke(Long id, Joke joke) {
        if (!jokeRepository.existsById(id)) {
            throw new JokeNotFoundException(id);
        }
        joke.setId(id);
        jokeRepository.save(joke);
    }

    @Override
    public void deleteJoke(Long id) {
        if (!jokeRepository.existsById(id)) {
            throw new JokeNotFoundException(id);
        }
        jokeRepository.deleteById(id);
    }
}
