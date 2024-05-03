package com.example.l2.dto;

import lombok.Data;

// для передачи данных в запрос
@Data
public class BookDTO {

    private String title;
    private String description;
    private Integer price;
    private Integer pages;

    private Long genreId;
}
