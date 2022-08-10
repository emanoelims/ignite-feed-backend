package dev.emmanoel.ignitefeedbackend.domain.post;

import dev.emmanoel.ignitefeedbackend.domain.AbstractEntity;
import dev.emmanoel.ignitefeedbackend.domain.IAggregateRoot;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Post extends AbstractEntity implements IAggregateRoot {
    private final UUID authorId;
    private final Content content;
    private final LocalDateTime publicationDate;

    public Post(final UUID authorId, final Content content, final LocalDateTime publicationDate) {
        this.authorId = Objects.requireNonNull(authorId);
        this.content = Objects.requireNonNull(content);
        this.publicationDate = Objects.requireNonNull(publicationDate);
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public Content getContent() {
        return content;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }
}
