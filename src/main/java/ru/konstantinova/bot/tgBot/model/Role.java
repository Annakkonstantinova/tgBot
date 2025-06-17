package ru.konstantinova.bot.tgBot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "roles")
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    @SequenceGenerator(sequenceName = "role_id_seq", name = "role_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "role_authorities", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "authority")
    private Set<String> authorities;

    // Геттеры
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    // Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}