package com.dauphine.blogger.controllers;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAll();
    Category getById(UUID id);
    Category create(String name);
    Category updateName(String name, UUID id);
    void deleteById(UUID id);
}
