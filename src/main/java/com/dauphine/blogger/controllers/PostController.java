package com.dauphine.blogger.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
    
    private final PostService service;
    
    public PostController(PostService postService) {
        this.service = postService;
    }
    
    @GetMapping
    public List<Post> getAllPosts() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody PostRequest request) {
        return service.create(request.getTitle(), request.getContent(), request.getCategoryId());
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable UUID id, @RequestBody PostRequest request) {
        return service.updateName(request.getTitle(), id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable UUID id) {
        service.deleteById(id);
    }

    public static class PostRequest {
        private String title;
        private String content;
        private String categoryId;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }
    }
}
