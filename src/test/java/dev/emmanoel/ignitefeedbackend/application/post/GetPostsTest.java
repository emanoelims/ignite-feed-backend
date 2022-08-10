package dev.emmanoel.ignitefeedbackend.application.post;

import dev.emmanoel.ignitefeedbackend.application.post.getall.GetPosts;
import dev.emmanoel.ignitefeedbackend.domain.post.Content;
import dev.emmanoel.ignitefeedbackend.domain.post.Post;
import dev.emmanoel.ignitefeedbackend.domain.post.PostRepository;
import dev.emmanoel.ignitefeedbackend.domain.user.User;
import dev.emmanoel.ignitefeedbackend.domain.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPostsTest {

    @Mock
    private PostRepository postRepo;

    @Mock
    private UserRepository userRepo;

    @Test
    @DisplayName("should return list of posts")
    void shouldReturnListOfPosts() {
        var author = new User("Emmanoel", "CEO @MendesAssessoria");
        var post = new Post(author.getId(), new Content(), LocalDateTime.now());
        when(postRepo.findAll()).thenReturn(List.of(post, post));
        when(userRepo.findById(any())).thenReturn(Optional.of(author));
        var sut = new GetPosts(postRepo, userRepo);
        var posts = sut.execute();
        assertEquals(2, posts.size());
    }
}
