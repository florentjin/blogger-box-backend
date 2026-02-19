package com.dauphine.blogger.controllers;

import java.util.UUID;


public class Category {
    private UUID uuid;
    private String name;
    public Category(UUID id, String nom) {
        this.uuid = id;
        this.name = nom;


    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
