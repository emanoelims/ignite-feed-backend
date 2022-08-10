package dev.emmanoel.ignitefeedbackend.application.post.delete;

import dev.emmanoel.ignitefeedbackend.domain.post.PostRepository;

import java.util.UUID;

public class DeletePost {
    private final PostRepository postRepo;

    public DeletePost(PostRepository postRepository) {
        postRepo = postRepository;
    }

    public void execute(UUID id) {
        postRepo.delete(id);
    }
}
