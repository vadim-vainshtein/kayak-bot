package kz.vainshtein.kayakbotcore.entity.security;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    private final String name;
}
