package dev.emmanoel.ignitefeedbackend.domain;

import java.util.Objects;

public class Post {
    private final User author;

    public Post(final User author) {
        this.author = Objects.requireNonNull(author);
    }

    public User getAuthor() {
        return author;
    }
}
