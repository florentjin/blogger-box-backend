package com.dauphine.blogger.controllers;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAll(String name) {
        if (name == null || name.isBlank()) {
            return getAll();
        }
        return getAllLikeName(name);
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
    public Category updateName(String name, UUID id) {
        Category category = getById(id);
        if (category == null) {
            return null;
        }
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(UUID id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAllLikeName(String name) {
        return categoryRepository.findAllLikeName(name);
    }
}
