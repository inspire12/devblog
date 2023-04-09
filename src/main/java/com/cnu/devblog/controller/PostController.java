package com.cnu.devblog.controller;

import com.cnu.devblog.config.QueryStringArgResolver;
import com.cnu.devblog.entity.Post;
import com.cnu.devblog.model.request.PostListRequest;
import com.cnu.devblog.model.request.PostRequest;
import com.cnu.devblog.model.type.Tag;
import com.cnu.devblog.repository.persistence.post.PostSpecification;
import com.cnu.devblog.service.PostService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest) {

        return ResponseEntity.ok(postService.createPost(postRequest));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        return postService.getPost(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping
    public ResponseEntity<Page<Post>> getPosts(@QueryStringArgResolver PostListRequest postListRequest,
                                               @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.ok(postService.getPosts(postListRequest, pageable));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Post>> getPosts(@QueryStringArgResolver PostListRequest postListRequest) {
        return ResponseEntity.ok(postService.getPosts(postListRequest, Pageable.unpaged()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id,
                                           @RequestBody PostRequest postRequest) {
        return ResponseEntity.ok(postService.updatePost(id, postRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
