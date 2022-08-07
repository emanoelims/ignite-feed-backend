package dev.emmanoel.ignitefeedbackend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PostTest {

    @Test
    @DisplayName("should not create post without author")
    void shouldNotCreatePostWithoutAuthor() {
        assertThrows(NullPointerException.class, () -> new Post(null));
    }
}
