package dev.emmanoel.ignitefeedbackend.application.createpost;

import dev.emmanoel.ignitefeedbackend.domain.post.Content;
import dev.emmanoel.ignitefeedbackend.domain.post.ContentType;
import dev.emmanoel.ignitefeedbackend.domain.post.Post;
import dev.emmanoel.ignitefeedbackend.domain.post.PostRepository;
import dev.emmanoel.ignitefeedbackend.domain.user.UserNotFoundException;
import dev.emmanoel.ignitefeedbackend.domain.user.UserRepository;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CreatePost {
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public CreatePost(final PostRepository postRepository, final UserRepository userRepository) {
        postRepo = Objects.requireNonNull(postRepository);
        userRepo = Objects.requireNonNull(userRepository);
    }

    public CreatePostOutput execute(CreatePostInput input) {
        var author = userRepo.findById(input.userId())
            .orElseThrow(UserNotFoundException::new);
        var contents = input.content()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(e -> ContentType.valueOf(e.getKey().toUpperCase()), Map.Entry::getValue));
        var post = new Post(author, new Content(contents), input.publicationDate());
        postRepo.save(post);
        return new CreatePostOutput(post.getId());
    }
}
