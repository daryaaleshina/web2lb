package com.example.l2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // автоматическая генерация ID
    private Long id;
    private String title; // название книги
    private String description; // описание
    private Integer price; // цена
    private Integer pages; // количество страниц

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
