package uit.se122.ieltstinder.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uit.se122.ieltstinder.service.PostService;
import uit.se122.ieltstinder.service.dto.PostDto;

import java.util.List;

@RequestMapping(value = "/api/posts")
@RestController
@RequiredArgsConstructor
@Tag(name = "Post Resources")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getPosts() {
        return ResponseEntity.ok().body(postService.getAllPosts());
    }

}
