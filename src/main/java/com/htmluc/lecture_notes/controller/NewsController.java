package com.htmluc.lecture_notes.controller;

import com.htmluc.lecture_notes.model.NewsModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/news")
public class NewsController {
    private List<NewsModel> newsList = Arrays.asList(
            new NewsModel(1, "Spring Boot é incrível", "Tecnologia", "João"),
            new NewsModel(2, "O Mercado de TI em 2026", "Carreira", "Ana"),
            new NewsModel(3, "Aprenda Java rápido", "Tecnologia", "Beto"),
            new NewsModel(4, "A comida é incrível", "Culinária", "João")
    );

    @GetMapping("/{id}")
    public ResponseEntity<NewsModel> news(@PathVariable long id) {
        for(NewsModel news : newsList) {
            if(news.getId() == id) {
                return ResponseEntity.ok(news);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<NewsModel>> newsFilter(@RequestParam(value = "author", required = false) String author,
                                                      @RequestParam(value = "category", required = false) String category,
                                                      @RequestParam(value = "order", required = false, defaultValue = "inc") String order
    ) {

        if (author == null && category == null) {
            return ResponseEntity.badRequest().build();
        }

        Comparator<NewsModel> comparator = Comparator.comparing(
                NewsModel::getTitle,
                String.CASE_INSENSITIVE_ORDER
        );

        if ("dec".equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }

        List<NewsModel> newsFilterList = newsList.stream()
                .filter(news -> author == null || news.getAuthor().equalsIgnoreCase(author))
                .filter(news -> category == null || news.getCategory().equalsIgnoreCase(category))
                .sorted(comparator)
                .collect(Collectors.toList());

        return ResponseEntity.ok(newsFilterList);
    }
}
