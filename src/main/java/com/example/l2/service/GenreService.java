package com.example.l2.service;

import com.example.l2.entity.Genre;
import com.example.l2.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    // метод получения всех жанров
    public List<Genre> readAll() {
        return genreRepository.findAll();
    }

    // поиск по id жанра
    public Genre readById(Long id) {
        return genreRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Genre not found - " + id));
    }
}
