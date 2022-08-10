package dev.emmanoel.ignitefeedbackend.application.post;

import dev.emmanoel.ignitefeedbackend.application.post.get.GetPost;
import dev.emmanoel.ignitefeedbackend.domain.post.Content;
import dev.emmanoel.ignitefeedbackend.domain.post.Post;
import dev.emmanoel.ignitefeedbackend.domain.post.PostRepository;
import dev.emmanoel.ignitefeedbackend.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPostTest {

    @Mock
    private PostRepository postRepo;

    @Test
    @DisplayName("should return a post")
    void shouldReturnAPost() {
        var author = new User("Emmaneol", "CEO: @MendesAssessoria");
        var content = new Content();
        content.addParagraph("Olá pessoal, tudo joia?");
        var post = new Post(author, content, LocalDateTime.now());
        var sut = new GetPost(postRepo);
        when(postRepo.findById(any())).thenReturn(Optional.of(post));
        var output = sut.execute(post.getId());
        assertEquals(post.getAuthor().getId(), output.author().id());
        assertEquals(post.getContent().getContents().size(), output.content().size());
        assertEquals(post.getPublicationDate(), output.publicationDate());
    }
}
