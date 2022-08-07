package dev.emmanoel.ignitefeedbackend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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
        var author = new User("User");
        var publicationDate = LocalDateTime.now();
        assertThrows(NullPointerException.class, () -> new Post(author, null, publicationDate));
    }

    @Test
    @DisplayName("should not create post without publication date")
    void shouldNotCreatePostWithoutPublicationDate() {
        var author = new User("User");
        var content = new Content();
        assertThrows(NullPointerException.class, () -> new Post(author, content, null));
    }
}
