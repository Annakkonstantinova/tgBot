package ru.konstantinova.bot.tgBot.model;

import java.time.LocalDateTime;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity(name = "joke_calls")
@Table(name = "joke_calls")
public class JokeCall {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "joke_call_id_seq")
    @SequenceGenerator(sequenceName = "joke_call_id_seq", name = "joke_call_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "call_time", nullable = false)
    private LocalDateTime callTime;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "joke_id", nullable = false)
    private Joke joke;

    // Геттеры
    public Long getId() {
        return id;
    }
    public LocalDateTime getCallTime() {
        return callTime;
    }
    public Long getUserId() {
        return userId;
    }
    public Joke getJoke() {
        return joke;
    }

    // Сеттеры
    public void setId(Long id) {
        this.id = id;
    }
    public void setCallTime(LocalDateTime callTime) {
        this.callTime = callTime;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setJoke(Joke joke) {
        this.joke = joke;
    }
}