package com.dauphine.blogger.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="post")
public class Post {
    @Id
    @Column(name="id")
    private String uuid;
    @Column(name="title")
    private String title;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name="created_date")
    private String date;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Post() {
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

}

