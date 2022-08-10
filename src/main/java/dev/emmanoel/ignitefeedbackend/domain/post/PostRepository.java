package dev.emmanoel.ignitefeedbackend.domain.post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository {
    List<Post> findAll();

    void save(Post post);

    Optional<Post> findById(UUID id);
}
