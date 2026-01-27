package com.htmluc.lecture_notes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NewsModel {
    long id;
    String title;
    String category;
    String author;
}
