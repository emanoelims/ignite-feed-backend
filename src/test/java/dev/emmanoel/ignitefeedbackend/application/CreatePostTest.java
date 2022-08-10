package dev.emmanoel.ignitefeedbackend.application;

import dev.emmanoel.ignitefeedbackend.application.createpost.CreatePost;
import dev.emmanoel.ignitefeedbackend.application.createpost.CreatePostInput;
import dev.emmanoel.ignitefeedbackend.domain.post.PostRepository;
import dev.emmanoel.ignitefeedbackend.domain.user.User;
import dev.emmanoel.ignitefeedbackend.domain.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreatePostTest {
    @Mock
    private PostRepository postRepository;
    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("should create a post")
    void shouldCreateAPost() {
        var user = new User("Emmanoel", "CEO @MendesAssessoria");
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        var content = new HashMap<String, List<String>>();
        content.computeIfAbsent("paragraph", s -> new ArrayList<>());
        content.computeIfAbsent("anchor", s -> new ArrayList<>());
        content.get("paragraph").add("Olá pessoal, tudo bem?");
        content.get("paragraph").add("Verifique nosso novo site");
        content.get("anchor").add("acessar o site");
        var publicationDate = LocalDateTime.now();
        var input = new CreatePostInput(UUID.randomUUID(), content, publicationDate);
        var sut = new CreatePost(postRepository, userRepository);
        var output = sut.execute(input);
        verify(postRepository, times(1)).save(any());
        assertNotNull(output.postId());
    }
}
