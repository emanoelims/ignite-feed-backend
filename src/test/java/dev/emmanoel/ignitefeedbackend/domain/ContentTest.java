package dev.emmanoel.ignitefeedbackend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContentTest {

    @Test
    @DisplayName("should add a paragraph to the Content")
    void shouldAddAParagraphToTheContent() {
        var content = new Content();
        content.addParagraph("Fala pessoal, tudo joia?");
        assertEquals(1, content.paragraphCount());
    }
}