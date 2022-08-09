package dev.emmanoel.ignitefeedbackend.application.getposts;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record GetPostsOutput(AuthorOutput author, Map<String, List<String>> content, LocalDateTime publicationDate) {
}

