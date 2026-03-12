package com.dauphine.blogger.controllers;

import com.dauphine.blogger.controllers.Post;
import com.dauphine.blogger.controllers.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    @Override
    public Post getById(UUID id) {
        return this.postRepository.findById(id).orElse(null);
    }

    @Override
    public Post create(String name) {
        Post post = new Post();
        post.setTitle(name);
        this.postRepository.save(post);
        return post;
    }

    @Override
    public Post updateName(String name,UUID id) {
        Post post = this.getById(id);
        if (post == null) {
            return null;
        }
        post.setTitle(name);
        this.postRepository.save(post);
        return post;
    }

    @Override
    public void deleteById(UUID id) {
        postRepository.deleteById(id);
        return;
    }
}

