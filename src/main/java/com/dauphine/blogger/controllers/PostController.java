package com.dauphine.blogger.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
    private final PostService service;
    public PostController(PostService PostService) {
        this.service = PostService;
    }
    @GetMapping
    public List<Post> getCategories() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Post getPostById(UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Post createPost(String name) {
        return service.create(name);
    }

    @PutMapping
    public Post updatePost(@PathVariable UUID id, @RequestBody String name) {
        return service.updateName(name, id);
    }

    @DeleteMapping
    public void deletePost(@PathVariable UUID id) {
        service.deleteById(id);
    }





}
