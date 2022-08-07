package dev.emmanoel.ignitefeedbackend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContentTest {

    @Test
    @DisplayName("should not add blank paragraph")
    void shouldNotAddBlankParagraphToTheContent() {
        var content = new Content();
        assertThrows(IllegalArgumentException.class, () -> content.addParagraph(""));
    }

    @Test
    @DisplayName("should add a paragraph to the Content")
    void shouldAddAParagraphToTheContent() {
        var content = new Content();
        content.addParagraph("Fala pessoal, tudo joia?");
        assertEquals(1, content.paragraphCount());
    }

    @Test
    @DisplayName("should add more than one paragraph")
    void shouldAddMoreThanOneParagraph() {
        var content = new Content();
        content.addParagraph("Fala pessoal, tudo joia?");
        content.addParagraph("Hoje vamos aprender mais sobre DDD e Clean Arch");
        assertEquals(2, content.paragraphCount());
    }

    @Test
    @DisplayName("should not add blank anchor")
    void shouldNotAddBlankAnchorToTheContent() {
        var content = new Content();
        assertThrows(IllegalArgumentException.class, () -> content.addAnchor(""));
    }

    @Test
    @DisplayName("should add an anchor to the Content")
    void shouldAddAnAnchorToTheContent() {
        var content = new Content();
        content.addAnchor("clique aqui para saber mais");
        assertEquals(1, content.anchorCount());
    }

}