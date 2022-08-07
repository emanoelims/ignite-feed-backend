package dev.emmanoel.ignitefeedbackend.domain;

import java.util.Objects;

public class User {
    private final String name;

    public User(final String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }
}
