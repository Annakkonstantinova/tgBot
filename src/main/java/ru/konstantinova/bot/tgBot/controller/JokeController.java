package ru.konstantinova.bot.tgBot.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.konstantinova.bot.tgBot.model.Joke;
import ru.konstantinova.bot.tgBot.service.JokeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jokes")
public class JokeController {

    private final JokeService jokeService;

    @PostMapping
    public ResponseEntity<Joke> createJoke(@RequestBody Joke joke) {
        return ResponseEntity.ok(jokeService.createJoke(joke));
    }

    @GetMapping
    public ResponseEntity<List<Joke>> getAllJokes(@RequestParam(value = "title", required = false) String title) {
        List<Joke> jokes = jokeService.getAllJoke(title);
        return ResponseEntity.ok(jokes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joke> getJokeById(@PathVariable Long id) {
        return ResponseEntity.ok(jokeService.getJokeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateJoke(@PathVariable("id") Long id, @RequestBody Joke joke) {
        jokeService.updateJoke(id, joke);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoke(@PathVariable Long id) {
        jokeService.deleteJoke(id);
        return ResponseEntity.noContent().build();
    }
}
