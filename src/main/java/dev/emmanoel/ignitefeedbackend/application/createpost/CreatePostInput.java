package dev.emmanoel.ignitefeedbackend.application.createpost;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public record CreatePostInput(UUID userId, HashMap<String, List<String>> content,
                              LocalDateTime publicationDate) {
}
