package com.dauphine.blogger.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAll();

    @GetMapping
    @Operation(
            summary = "Get all categories",
            description = "Retrieve all categories or filter like name"
    )
    List<Category> getAll(@RequestParam(required = false) String name);

    Category getById(UUID id);
    Category create(String name);
    Category updateName(String name, UUID id);
    void deleteById(UUID id);

    List<Category> getAllLikeName(String name);
}
