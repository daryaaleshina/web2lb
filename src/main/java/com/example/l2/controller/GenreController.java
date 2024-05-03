package com.example.l2.controller;

import com.example.l2.entity.Genre;
import com.example.l2.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping(value = "/books/genres")
    public ResponseEntity<List<Genre>> readAll() {
        return new ResponseEntity<>(genreService.readAll(), HttpStatus.OK);
    }
}