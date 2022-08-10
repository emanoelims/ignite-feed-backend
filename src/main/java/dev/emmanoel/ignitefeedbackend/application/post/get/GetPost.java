package dev.emmanoel.ignitefeedbackend.application.post.get;

import dev.emmanoel.ignitefeedbackend.domain.post.PostNotFoundException;
import dev.emmanoel.ignitefeedbackend.domain.post.PostRepository;
import dev.emmanoel.ignitefeedbackend.domain.user.UserNotFoundException;
import dev.emmanoel.ignitefeedbackend.domain.user.UserRepository;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class GetPost {

    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public GetPost(final PostRepository postRepository, final UserRepository userRepository) {
        postRepo = postRepository;
        userRepo = userRepository;
    }

    public GetPostOutput execute(final UUID id) {
        var post = postRepo.findById(id).orElseThrow(PostNotFoundException::new);
        var author = userRepo.findById(post.getAuthorId()).orElseThrow(UserNotFoundException::new);
        var content = post.getContent()
            .getContents()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(e -> e.getKey().toString().toLowerCase(), Map.Entry::getValue));
        return new GetPostOutput(AuthorOutput.of(author), content, post.getPublicationDate());
    }
}
