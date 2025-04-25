package ru.konstantinova.bot.tgBot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.konstantinova.bot.tgBot.model.Joke;

import java.util.List;

@Component
public class TelegramUpdateListener implements UpdatesListener {

    private final JokeService jokeService;
    private final TelegramBot telegramBot;

    public TelegramUpdateListener(JokeService jokeService, TelegramBot telegramBot) {
        this.jokeService = jokeService;
        this.telegramBot = telegramBot;
    }

    @Override
    public int process(List<Update> updates) {
        for (Update update : updates) {
            if (update.message() != null && update.message().text() != null) {
                handleMessage(update);
            }
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void handleMessage(Update update) {
        String messageText = update.message().text();
        Long chatId = update.message().chat().id();

        switch (messageText) {
            case "/start":
                sendWelcomeMessage(chatId);
                break;
            case "/joke":
                sendRandomJoke(chatId);
                break;
            default:
                sendUnknownCommand(chatId);
        }
    }

    private void sendWelcomeMessage(Long chatId) {
        String welcomeText = "Привет! Я бот с шутками.\n" +
                "Доступные команды:\n" +
                "/joke - случайная шутка";
        telegramBot.execute(new SendMessage(chatId, welcomeText));
    }

    private void sendRandomJoke(Long chatId) {
        List<Joke> jokes = jokeService.getAllJoke(null);

        if (!jokes.isEmpty()) {
            Joke randomJoke = jokes.get((int) (Math.random() * jokes.size()));
            String jokeText = formatJoke(randomJoke);
            telegramBot.execute(new SendMessage(chatId, jokeText));
        } else {
            telegramBot.execute(new SendMessage(chatId, "Шутки закончились 😢"));
        }
    }

    private String formatJoke(Joke joke) {
        return "\"" + joke.getTitle() + "\"\n\n" + joke.getContent();
    }

    private void sendUnknownCommand(Long chatId) {
        telegramBot.execute(new SendMessage(chatId, "Неизвестная команда. Напишите /start для списка команд"));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        telegramBot.setUpdatesListener(this);
    }
}