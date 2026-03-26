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
        return service.create(request.getTitle());
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable UUID id, @RequestBody PostRequest request) {
        return service.updateName(request.getTitle(), id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable UUID id) {
        service.deleteById(id);
    }
}

/**
 * DTO interne pour recevoir les requêtes de création/modification
 */
class PostRequest {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
