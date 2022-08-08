package dev.emmanoel.ignitefeedbackend.domain.post;

import dev.emmanoel.ignitefeedbackend.domain.AbstractEntity;
import dev.emmanoel.ignitefeedbackend.domain.IAggregateRoot;
import dev.emmanoel.ignitefeedbackend.domain.user.User;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post extends AbstractEntity implements IAggregateRoot {
    private final User author;
    private final Content content;
    private final LocalDateTime publicationDate;

    public Post(final User author, final Content content, final LocalDateTime publicationDate) {
        this.author = Objects.requireNonNull(author);
        this.content = Objects.requireNonNull(content);
        this.publicationDate = Objects.requireNonNull(publicationDate);
    }

    public User getAuthor() {
        return author;
    }

    public Content getContent() {
        return content;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }
}
