package com.dauphine.blogger.controllers;

import java.util.UUID;

public class Post {
    private String uuid;
    private String title;
    private String author;
    private String content;
    public Post(String uuid, String title, String author, String content) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
        this.content = content;

    }

    public Post(UUID uuid, String sport) {
    }

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

}

