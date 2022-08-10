package dev.emmanoel.ignitefeedbackend.domain.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PostTest {

    @Test
    @DisplayName("should not create post without author")
    void shouldNotCreatePostWithoutAuthor() {
        var content = new Content();
        var publicationDate = LocalDateTime.now();
        assertThrows(NullPointerException.class, () -> new Post(null, content, publicationDate));
    }

    @Test
    @DisplayName("should not create post without content")
    void shouldNotCreatePostWithoutContent() {
        var authorId = UUID.randomUUID();
        var publicationDate = LocalDateTime.now();
        assertThrows(NullPointerException.class, () -> new Post(authorId, null, publicationDate));
    }

    @Test
    @DisplayName("should not create post without publication date")
    void shouldNotCreatePostWithoutPublicationDate() {
        var authorId = UUID.randomUUID();
        var content = new Content();
        assertThrows(NullPointerException.class, () -> new Post(authorId, content, null));
    }
}
