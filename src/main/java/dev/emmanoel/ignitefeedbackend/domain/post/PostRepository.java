package dev.emmanoel.ignitefeedbackend.domain.post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();

    void save(Post post);
}
