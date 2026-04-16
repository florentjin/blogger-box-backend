package com.dauphine.blogger.controllers;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public PostServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Post> getAll() {
        return this.postRepository.findAllByOrderByDateDesc();
    }

    @Override
    public Post getById(UUID id) {
        return this.postRepository.findById(id).orElse(null);
    }

    @Override
    public Post create(String title, String content, String categoryId) {
        Post post = new Post();
        post.setUuid(UUID.randomUUID());
        post.setTitle(title);
        post.setContent(content);
        post.setDate(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneId.of("UTC")).format(Instant.now()));

        if (categoryId != null && !categoryId.isEmpty()) {
            Category category = categoryRepository.findById(UUID.fromString(categoryId)).orElse(null);
            post.setCategory(category);
        }

        return this.postRepository.save(post);
    }

    @Override
    public Post updateName(String title, UUID id) {
        Post post = this.getById(id);
        if (post == null) {
            return null;
        }
        post.setTitle(title);
        return this.postRepository.save(post);
    }

    @Override
    public void deleteById(UUID id) {
        postRepository.deleteById(id);
    }
}

