package com.dauphine.blogger.controllers;

import java.util.UUID;


public class Category {
    private UUID uuid;
    private String name;
    public Category(UUID id, String nom) {
        this.uuid = id;
        this.name = nom;


    }
}
