package com.dauphine.blogger.controllers;

import org.springframework.web.bind.annotation.*;

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
    public List<Category> getAllCategories() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryRequest request) {
        return service.create(request.getName());
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable UUID id, @RequestBody CategoryRequest request) {
        return service.updateName(request.getName(), id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable UUID id) {
        service.deleteById(id);
    }
}

class CategoryRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
