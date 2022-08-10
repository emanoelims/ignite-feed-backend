package dev.emmanoel.ignitefeedbackend.application.post.getall;

import dev.emmanoel.ignitefeedbackend.domain.post.PostRepository;
import dev.emmanoel.ignitefeedbackend.domain.user.UserNotFoundException;
import dev.emmanoel.ignitefeedbackend.domain.user.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static dev.emmanoel.ignitefeedbackend.application.post.getall.AuthorOutput.createAuthorOutputOf;
import static dev.emmanoel.ignitefeedbackend.application.post.getall.GetPostsOutput.createGetPostsOutputWith;

public class GetPosts {
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public GetPosts(final PostRepository postRepository, final UserRepository userRepository) {
        postRepo = postRepository;
        userRepo = userRepository;
    }

    public List<GetPostsOutput> execute() {
        return postRepo.findAll().stream().map(post -> {
            var author = userRepo.findById(post.getAuthorId()).orElseThrow(UserNotFoundException::new);
            var authorOutput = createAuthorOutputOf(author);
            var content = post.getContent()
                .getContents()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().toString(), Map.Entry::getValue));
            return createGetPostsOutputWith(authorOutput, content, post.getPublicationDate());
        }).toList();
    }
}
