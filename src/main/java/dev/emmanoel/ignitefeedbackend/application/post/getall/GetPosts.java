package dev.emmanoel.ignitefeedbackend.application.post.getall;

import dev.emmanoel.ignitefeedbackend.domain.post.PostRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetPosts {
    private final PostRepository postRepo;

    public GetPosts(PostRepository postRepository) {
        postRepo = postRepository;
    }

    public List<GetPostsOutput> execute() {
        return postRepo.findAll().stream().map(post -> {
            var author = new AuthorOutput(post.getAuthor().getName(), post.getAuthor().getRole());
            var content = post.getContent()
                .getContents()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().toString(), Map.Entry::getValue));
            return new GetPostsOutput(author, content, post.getPublicationDate());
        }).toList();
    }
}
