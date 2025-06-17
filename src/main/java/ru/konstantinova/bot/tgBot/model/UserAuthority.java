package ru.konstantinova.bot.tgBot.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserAuthority implements GrantedAuthority {
    FULL,
    MANAGE_ORDERS,
    PLACE_ORDERS;

    @Override
    public String getAuthority() {
        return name();
    }
}
