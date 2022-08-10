package dev.emmanoel.ignitefeedbackend.application.post;

import dev.emmanoel.ignitefeedbackend.application.post.getall.GetPosts;
import dev.emmanoel.ignitefeedbackend.domain.post.Content;
import dev.emmanoel.ignitefeedbackend.domain.post.Post;
import dev.emmanoel.ignitefeedbackend.domain.post.PostRepository;
import dev.emmanoel.ignitefeedbackend.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetPostsTest {

    @Test
    @DisplayName("should return list of posts")
    void shouldReturnListOfPosts() {
        var post = new Post(new User("Emmanoel", "CEO @MendesAssessoria"), new Content(), LocalDateTime.now());
        var postRepo = mock(PostRepository.class);
        when(postRepo.findAll()).thenReturn(List.of(post, post));
        var sut = new GetPosts(postRepo);
        var posts = sut.execute();
        assertEquals(2, posts.size());
    }
}
