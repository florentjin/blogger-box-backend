package com.dauphine.blogger.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final CategoryService service;
    public CategoryController(CategoryService categoryService) {
        this.service = categoryService;
    }
    @GetMapping
    public List<Category> getCategories() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Category getCategoryById(UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Category createCategory(String name) {
        return service.create(name);
    }

    @PutMapping
    public Category updateCategory(@PathVariable UUID id, @RequestBody String name) {
        return service.updateName(name, id);
    }

    @DeleteMapping
    public void deleteCategory(@PathVariable UUID id) {
        service.deleteById(id);
    }





}
