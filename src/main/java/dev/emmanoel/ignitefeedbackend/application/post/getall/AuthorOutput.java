package dev.emmanoel.ignitefeedbackend.application.post.getall;

import dev.emmanoel.ignitefeedbackend.domain.user.User;

public record AuthorOutput(String name, String role) {
    public static AuthorOutput createAuthorOutputOf(final User author) {
        return new AuthorOutput(author.getName(), author.getRole());
    }
}
