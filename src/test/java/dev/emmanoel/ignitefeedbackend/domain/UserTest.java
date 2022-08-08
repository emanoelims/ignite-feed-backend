package dev.emmanoel.ignitefeedbackend.domain;

import dev.emmanoel.ignitefeedbackend.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("should not create unnamed user")
    void shouldNotCreateUnnamedUser() {
        assertThrows(NullPointerException.class, () -> new User(null, "CEO"));
    }

    @Test
    @DisplayName("should not create User without role")
    void shouldNotCreateUserWithoutRole() {
        var name = "Emmanoel";
        assertThrows(NullPointerException.class, () -> new User(name, null));
    }

}