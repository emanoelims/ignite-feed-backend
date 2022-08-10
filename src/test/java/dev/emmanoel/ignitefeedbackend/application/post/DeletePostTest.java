package dev.emmanoel.ignitefeedbackend.application.post;

import dev.emmanoel.ignitefeedbackend.application.post.delete.DeletePost;
import dev.emmanoel.ignitefeedbackend.domain.post.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeletePostTest {

    @Mock
    private PostRepository postRepository;

    @Test
    @DisplayName("should delete a post")
    void shouldDeleteAPost() {
        var sut = new DeletePost(postRepository);
        sut.execute(UUID.randomUUID());
        verify(postRepository, times(1)).delete(any());
    }
}
