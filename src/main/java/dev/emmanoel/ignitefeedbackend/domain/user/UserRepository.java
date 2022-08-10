package dev.emmanoel.ignitefeedbackend.domain.user;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);
}
