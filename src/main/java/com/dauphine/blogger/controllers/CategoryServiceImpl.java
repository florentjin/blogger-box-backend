package com.dauphine.blogger.controllers;

import com.dauphine.blogger.controllers.Category;
import com.dauphine.blogger.controllers.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final List<Category> temporaryCategories;


    public CategoryServiceImpl() {
        temporaryCategories = new ArrayList<>();
        temporaryCategories.add(new Category(UUID.randomUUID(),"Sport"));
        temporaryCategories.add(new Category(UUID.randomUUID(),"Culture"));
        temporaryCategories.add(new Category(UUID.randomUUID(),"Politique"));
    }

    @Override
    public List<Category> getAll() {
        return temporaryCategories;
    }

    @Override
    public Category getById(UUID id) {
        return temporaryCategories.stream().filter(category -> category.getUuid().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Category create(String name) {
        return new Category(UUID.randomUUID(),name);
    }

    @Override
    public Category updateName(String name,UUID id) {
        Category category = temporaryCategories.stream().filter(category1 -> category1.getUuid().equals(id)).findFirst().orElse(null);
        if( category != null)
            category.setName(name);
        return category;
    }

    @Override
    public void deleteById(UUID id) {
        temporaryCategories.removeIf(category -> category.getUuid().equals(id));
    }
}
