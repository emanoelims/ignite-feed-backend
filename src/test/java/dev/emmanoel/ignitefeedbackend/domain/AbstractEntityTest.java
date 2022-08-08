package dev.emmanoel.ignitefeedbackend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.spy;

class AbstractEntityTest {


    @Test
    @DisplayName("should return a valid uuid")
    void shouldReturnAValidUUID() {
        var sut = spy(AbstractEntity.class);
        assertInstanceOf(UUID.class, sut.getId());
    }
}
