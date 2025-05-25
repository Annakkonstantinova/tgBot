package ru.konstantinova.bot.tgBot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.konstantinova.bot.tgBot.model.Joke;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JokeRepository extends PagingAndSortingRepository<Joke, Long>, CrudRepository<Joke, Long> {
    Page<Joke> findByTitleContaining(String title, Pageable pageable);
}