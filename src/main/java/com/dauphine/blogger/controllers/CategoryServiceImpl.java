package com.dauphine.blogger.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;


    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Category> getAll() {
        return List.of();
    }

    @GetMapping
    @Operation(
            summary = "Get all categories",
            description = "Retrieve all categories or filter like name"
    )
    @Override
    public List<Category> getAll(@RequestParam(required = false) String name) {
        List<Category> categories = name == null||name.isBlank()
                ?categoryService.getAll()
                :categoryService.getAllLikeName(name);
        return categories;
    }

    @Override
    public Category getById(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category create(String name) {
        Category category = new Category(UUID.randomUUID(), name);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateName(String name,UUID id) {
        Category category = getById(id);
        if (category == null) {
            return null;
        }

        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(UUID id) {
        categoryRepository.deleteById(id);}

    @Override
    public List<Category> getAllLikeName(String name) {
        return List.of();
    }
}
