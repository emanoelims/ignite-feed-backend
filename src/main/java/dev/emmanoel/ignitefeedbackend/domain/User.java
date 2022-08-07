package dev.emmanoel.ignitefeedbackend.domain;

import java.util.Objects;

public class User {
    private final String name;
    private final String role;

    public User(final String name, final String role) {
        this.name = Objects.requireNonNull(name);
        this.role = Objects.requireNonNull(role);
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
