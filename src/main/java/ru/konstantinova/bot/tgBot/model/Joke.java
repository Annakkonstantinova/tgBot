package ru.konstantinova.bot.tgBot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "jokes")
@Table(name = "jokes")
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "joke_id_seq")
    @SequenceGenerator(sequenceName = "joke_id_seq", name = "joke_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    // Геттеры
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    // Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
