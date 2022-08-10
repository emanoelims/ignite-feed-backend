package dev.emmanoel.ignitefeedbackend.application.post.get;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record GetPostOutput(AuthorOutput author, Map<String, List<String>> content, LocalDateTime publicationDate) {
}
