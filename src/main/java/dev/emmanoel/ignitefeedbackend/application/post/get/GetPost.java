package dev.emmanoel.ignitefeedbackend.application.post.get;

import dev.emmanoel.ignitefeedbackend.domain.post.PostNotFoundException;
import dev.emmanoel.ignitefeedbackend.domain.post.PostRepository;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class GetPost {

    private final PostRepository postRepo;

    public GetPost(final PostRepository postRepository) {
        postRepo = postRepository;
    }

    public GetPostOutput execute(UUID id) {
        var post = postRepo.findById(id).orElseThrow(PostNotFoundException::new);
        var content = post.getContent()
            .getContents()
            .entrySet()
            .stream()
            .collect(Collectors.toMap(e -> e.getKey().toString().toLowerCase(), Map.Entry::getValue));
        return new GetPostOutput(AuthorOutput.of(post.getAuthor()), content, post.getPublicationDate());
    }
}
