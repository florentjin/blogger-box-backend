package com.dauphine.blogger.controllers;

import com.dauphine.blogger.controllers.Post;
import com.dauphine.blogger.controllers.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class PostServiceImpl implements PostService {

    private final List<Post> temporaryCategories;


    public PostServiceImpl() {
        temporaryCategories = new ArrayList<>();
        temporaryCategories.add(new Post(UUID.randomUUID(),"Sport"));
        temporaryCategories.add(new Post(UUID.randomUUID(),"Culture"));
        temporaryCategories.add(new Post(UUID.randomUUID(),"Politique"));
    }

    @Override
    public List<Post> getAll() {
        return temporaryCategories;
    }

    @Override
    public Post getById(UUID id) {
        return temporaryCategories.stream().filter(Post -> Post.getUuid().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Post create(String name) {
        return new Post(UUID.randomUUID(),name);
    }

    @Override
    public Post updateName(String name,UUID id) {
        Post Post = temporaryCategories.stream().filter(Post1 -> Post1.getUuid().equals(id)).findFirst().orElse(null);
        if( Post != null)
            Post.setTitle(name);
        return Post;
    }

    @Override
    public void deleteById(UUID id) {
        temporaryCategories.removeIf(Post -> Post.getUuid().equals(id));
    }
}

