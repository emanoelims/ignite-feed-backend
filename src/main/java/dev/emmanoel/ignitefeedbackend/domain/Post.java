package dev.emmanoel.ignitefeedbackend.domain;

import java.util.Objects;

public class Post {
    private final User author;
    private final Content content;

    public Post(final User author, final Content content) {
        this.author = Objects.requireNonNull(author);
        this.content = Objects.requireNonNull(content);
    }

    public User getAuthor() {
        return author;
    }

    public Content getContent() {
        return content;
    }
}
