package dev.emmanoel.ignitefeedbackend.application.post.get;

import dev.emmanoel.ignitefeedbackend.domain.user.User;

import java.util.UUID;

public record AuthorOutput(UUID id, String name, String role) {

    static AuthorOutput of(final User author) {
        return new AuthorOutput(author.getId(), author.getName(), author.getRole());
    }
}
