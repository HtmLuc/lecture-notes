package com.htmluc.lecture_notes.model;

public class NewsModel {
    long id;
    String title;
    String category;
    String author;

    public NewsModel(long id, String title, String category, String author) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }
}
