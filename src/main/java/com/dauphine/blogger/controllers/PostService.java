package com.dauphine.blogger.controllers;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAll();
    Post getById(UUID id);
    Post create(String title, String content, String categoryId);
    Post updateName(String name, UUID id);
    void deleteById(UUID id);
}
